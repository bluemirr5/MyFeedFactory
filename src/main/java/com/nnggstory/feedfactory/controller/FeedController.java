package com.nnggstory.feedfactory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nnggstory.feedfactory.model.RssPulishChannelModel;
import com.nnggstory.feedfactory.service.FeedService;

/**
 * 실제 사용자가 피드를 받기 위한 컨트롤러 클래스.
 * 
 * @author bluemirr5
 *
 */
@Controller
public class FeedController {
	@Autowired
	private FeedService feedService;
	
	@RequestMapping(
			value="/rss/userId/{userId}/groupId/{groupId}",
			method=RequestMethod.GET
			)
	public @ResponseBody RssPulishChannelModel getRss(
			@PathVariable String userId,
			@PathVariable String groupId
			) throws Exception {
		RssPulishChannelModel resultModel = feedService.getRssByUserNGroup(userId, groupId);
		return resultModel;
	}
}