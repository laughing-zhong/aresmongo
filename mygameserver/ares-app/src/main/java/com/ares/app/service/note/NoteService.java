package com.ares.app.service.note;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.ares.app.constdata.Const;
import com.ares.app.dao.NoteDAO;
import com.ares.app.domain.Do.NoteDO;
import com.ares.framework.rpc.RpcResponse;
import com.ares.framework.service.RpcService;


@Component
public class NoteService implements RpcService{
	
	@Inject
	private NoteDAO noteDAO;
	
	public RpcResponse getTopics(Model modle){		
		List<NoteDO>  noteDoList = noteDAO.findAll();
		
		//for test 
		for(int i = 0 ; i < 10 ; i ++){
			NoteDO noteDo = new NoteDO();
			noteDo.setTopic("topic"+i);
			noteDoList.add(noteDo);
		}
		
		//test end
		List<TopicBean> topicBeans = new ArrayList<TopicBean>();
		for(NoteDO ndo : noteDoList){
			TopicBean  topicBean = new TopicBean();
			topicBean.setSenderName("zhong");
			topicBean.setTopic(ndo.getTopic());
			//topicBean.setType(ndo.getType());
		}
		modle.addAttribute(Const.TOPIC_LIST, topicBeans);
		RpcResponse  response = new RpcResponse();
		response.WebPage = "topicList";
		return response;	
	}
}
