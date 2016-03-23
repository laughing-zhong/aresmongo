package com.ares.app.service.note;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.ares.app.bean.TopicBean;
import com.ares.app.bean.TopicCategoryBean;
import com.ares.app.bean.TopicIDBean;
import com.ares.app.constdata.Const;
import com.ares.app.dao.NoteCatagoryDAO;
import com.ares.app.dao.NoteDAO;
import com.ares.app.domain.Do.NoteCatagoryDO;
import com.ares.app.domain.Do.NoteDO;
import com.ares.app.domain.Do.NoteDO.SubNote;
import com.ares.framework.rpc.RpcResponse;
import com.ares.framework.rpc.ViewResponse;
import com.ares.framework.rpc.context.RpcContext;
import com.ares.framework.service.RpcService;
import com.ares.framework.util.DateUtils;
import com.ares.framework.util.IdUtils;


@Component
public class NoteService implements RpcService{	
	@Inject
	private NoteDAO noteDAO;
	@Inject 
	private NoteCatagoryDAO noteCatagoryDAO;
	@Inject
	private Provider<RpcContext> rpcContextProvier;
	
	public ViewResponse topicList(Model modle){		
		List<NoteCatagoryDO>  noteCatagoryList = noteCatagoryDAO.findAll();
	
		List<TopicCategoryBean> topicBeans = new ArrayList<TopicCategoryBean>();
		for(NoteCatagoryDO ndo : noteCatagoryList){
			TopicCategoryBean  topicBean = new TopicCategoryBean();
			topicBean.setSenderName(ndo.getSender());
			topicBean.setTitle(ndo.getTitle());
			topicBean.setSenderTime(ndo.getSendTime());
			topicBean.setLastRplTime(ndo.getLastRplTime());
			//topicBean.setType(ndo.getType());
			topicBean.setId(ndo.getTopicId());
			topicBeans.add(topicBean);
		}
		modle.addAttribute(Const.TOPIC_LIST, topicBeans);
		ViewResponse  response = new ViewResponse();
		response.WebPage = "topic_list";
		return response;	
	}
	
	public ViewResponse sendTopicView(Model model){		
		ViewResponse response =  new ViewResponse();
		response.WebPage = "topic_send";
		return  response;
	}
	public ViewResponse topicDetail(TopicIDBean topicID, Model model){
		NoteDO noteDO = this.noteDAO.findById(topicID.getTopicID());
		model.addAttribute(Const.TOPIC_DETAIL, noteDO);
		ViewResponse response = new ViewResponse();
		response.WebPage = "topic_detail";
		return response;
		
	}
	public RpcResponse publishTopic(TopicBean topicBean){		
		// create note
		NoteDO noteDo = new NoteDO();
		noteDo.setId(IdUtils.generate());
		noteDo.setContent(topicBean.getContent());
		noteDo.setTitle(topicBean.getTitle());	
		noteDo.setSendUserName(rpcContextProvier.get().getUserID());
		
		// create note catagory
		NoteCatagoryDO catagoryDO = new NoteCatagoryDO();
		catagoryDO.setId(IdUtils.generate());
		catagoryDO.setTitle(topicBean.getTitle());
		catagoryDO.setTopicId(noteDo.getId());
		catagoryDO.setSender(this.rpcContextProvier.get().getAccountID());
		catagoryDO.setSendTime(DateUtils.GetCurrentTime());
		this.noteCatagoryDAO.upsert(catagoryDO);
		noteDo.setCatagoryId(catagoryDO.getId());
		this.noteDAO.upsert(noteDo);
		
		//tell  client to call topicDetail method with topicID to get note details
		RpcResponse  response = new RpcResponse();
		response.setMethod("topicDetail");
		response.setService("NoteService");
		response.append("topicID", noteDo.getId());
		return response;
	}
	public RpcResponse replyTopic(TopicBean topicBean){
		NoteDO noteDO = this.noteDAO.findById(topicBean.getId());
		SubNote  subNote = new SubNote();
		subNote.setContent(topicBean.getContent());
		subNote.setSendName(this.rpcContextProvier.get().getAccountID());
		List<SubNote> subNoteList = noteDO.getSubNoteList();
		if(subNoteList == null){
			subNoteList = new ArrayList<SubNote>();
		}
		subNoteList.add(subNote);
		noteDO.setSubNoteList(subNoteList);
		noteDAO.upsert(noteDO);
		
		NoteCatagoryDO  noteCatagoryDO = noteCatagoryDAO.findById(noteDO.getCatagoryId());
		noteCatagoryDO.setLastRplTime(DateUtils.GetCurrentTime());
		noteCatagoryDAO.upsert(noteCatagoryDO);
		
		//tell  client to call topicDetail method with topicID to get note details
		RpcResponse  response = new RpcResponse();
		response.setMethod("topicDetail");
		response.setService("NoteService");
		response.append("topicID", noteDO.getId());
		return response;		
	}
}
