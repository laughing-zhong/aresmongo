package com.ares.app.service.note;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.ares.app.bean.TopicBean;
import com.ares.app.bean.TopicCategoryBean;
import com.ares.app.bean.TopicIDBean;
import com.ares.app.constdata.Const;
import com.ares.app.dao.NoteDAO;
import com.ares.app.domain.Do.NoteDO;
import com.ares.framework.rpc.RpcResponse;
import com.ares.framework.rpc.ViewResponse;
import com.ares.framework.rpc.context.RpcContext;
import com.ares.framework.service.RpcService;
import com.ares.framework.util.IdUtils;


@Component
public class NoteService implements RpcService{	
	@Inject
	private NoteDAO noteDAO;
	@Inject
	private Provider<RpcContext> rpcContextProvier;
	
	public ViewResponse topicList(Model modle){		
		List<NoteDO>  noteDoList = noteDAO.findAll();
		
		//for test 
		for(int i = 0 ; i < 10 ; i ++){
			NoteDO noteDo = new NoteDO();
			noteDo.setTopic("topic"+i);
			noteDoList.add(noteDo);
		}
		
		//test end
		List<TopicCategoryBean> topicBeans = new ArrayList<TopicCategoryBean>();
		for(NoteDO ndo : noteDoList){
			TopicCategoryBean  topicBean = new TopicCategoryBean();
			topicBean.setSenderName("zhong");
			topicBean.setTopic(ndo.getTopic());
			//topicBean.setType(ndo.getType());
			topicBeans.add(topicBean);
		}
		modle.addAttribute(Const.TOPIC_LIST, topicBeans);
		ViewResponse  response = new ViewResponse();
		response.WebPage = "topicList";
		return response;	
	}
	
	public ViewResponse sendTopicView(Model model){		
		ViewResponse response =  new ViewResponse();
		response.WebPage = "default";
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
		NoteDO noteDo = new NoteDO();
		noteDo.setId(IdUtils.generate());
		noteDo.setContent(topicBean.getContent());
		noteDo.setSendUserName(rpcContextProvier.get().getUserID());
		this.noteDAO.upsert(noteDo);
		RpcResponse  response = new RpcResponse();
		response.setMethod("topicDetail");
		response.setService("NoteService");
		response.append("topicID", noteDo.getId());
		return response;
	}
}
