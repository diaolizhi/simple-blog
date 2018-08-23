package com.diaolizhi.simpleblog.controller;

import com.diaolizhi.simpleblog.domain.Message;
import com.diaolizhi.simpleblog.domain.MyPageInfo;
import com.diaolizhi.simpleblog.service.impl.MessageServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * @author diaolizhi
 * @version v1.0
 * @time 2018/8/8 13:10
 */

@Controller
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageServiceImpl messageService;

    /**
     * 进入留言板
     * @param pageNum
     * @param map
     * @return
     */
    @GetMapping("")
    public String index(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                        ModelMap map) {
//        这一句一定要在 selectAllMessage() 方法之前调用。
        PageHelper.startPage(pageNum,5, "message_time DESC");
        List<Message> messages = messageService.selectAllMessage();
        PageInfo<Message> pageInfo = new PageInfo<>(messages);

        List<Message> messages2 = pageInfo.getList();

//        导航栏分页
        MyPageInfo myPageInfo = new MyPageInfo();
        int[] navNums = pageInfo.getNavigatepageNums();
        int prePage = pageInfo.getPrePage();
        int nextPage = pageInfo.getNextPage();
        boolean hasPrePage = pageInfo.isHasPreviousPage();
        boolean hasNextPage = pageInfo.isHasNextPage();
        int currentNum = pageInfo.getPageNum();

        myPageInfo.setNavNums(navNums);
        myPageInfo.setHasPrePage(hasPrePage);
        myPageInfo.setHasNextPage(hasNextPage);
        myPageInfo.setPrePage(prePage);
        myPageInfo.setNextPage(nextPage);
        myPageInfo.setCurrentNum(currentNum);

        map.addAttribute("messages", messages2);
        map.addAttribute("myPageInfo", myPageInfo);

        return "/messages/index";
    }

    /**
     * 添加一条留言
     * @param speaker
     * @param message_content
     * @return
     */
    @PostMapping("/add-one-message")
    public String addOneMessage(String speaker, String message_content) {
        Message message = new Message();
        message.setSpeaker(speaker);
        message.setMessage_content(message_content);
        message.setMessage_time(new Date());

        messageService.insertOneMessage(message);

        return "redirect:/messages";
    }

    /**
     * 删除一条留言
     * @param id
     * @param pageNum
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/delete")
    public String deleteMessage(int id, int pageNum) {
        messageService.deleteMessageById(id);

        return "redirect:/messages?pageNum=" + pageNum;
    }
}
