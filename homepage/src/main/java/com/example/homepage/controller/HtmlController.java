package com.example.homepage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.homepage.model.Member;
import com.example.homepage.model.UserComment;
import com.example.homepage.repository.MemberRepository;
import com.example.homepage.repository.UserCommentRepository;
// import com.example.homepage.repository.UserContentRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class HtmlController {

    @Autowired
    private UserCommentRepository userCommentRepository;

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/register")
    public String register(HttpSession session){
        Member member = new Member();
        session.setAttribute("member",member);
        return "html/register";
    }
    
    @PostMapping("/register")
    public String registerPost(@RequestParam("memberId") String memberId,
                               @RequestParam("memberPw") String memberPw,
                               HttpSession session){
            int count = memberRepository.findByMemberId(memberId).size();
            Member member = new Member();
            member.setMemberId(memberId);
            member.setMemberPw(memberPw);
            
            session.setAttribute("member", member);
            if( count > 0){   
                return "html/registerfail";
            }
            memberRepository.save(member);

           return "redirect:/login";                   
    }
    
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("member", memberRepository.findAll());
        return "html/login";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam("memberId") String memberId,
                            @RequestParam("memberPw") String memberPw, 
                            HttpSession session){
        Member member;
        member = memberRepository.findByMemberIdAndMemberPw(memberId, memberPw);                   

        session.setAttribute("member",member);

        return "redirect:/LeeJaeBeen";
    }

    @GetMapping("/LeeJaeBeen")
    public String HomePage() {
        return "html/LeeJaeBeen";
    }



    // 글쓰기 싹 다 손보기 

    @GetMapping("/write")
    public String Write() {
        return "html/write";
    }

    @GetMapping("/writeInsert")
    public String WritePlace(
        @RequestParam("title") String title,
        @RequestParam("content") String content
        ) {

        return "html/contentInsert";

    }





    @GetMapping("/content")
    public String Content(Model model) {
        model.addAttribute("comment", userCommentRepository.findAll());
        return "html/content";
    }


    @GetMapping("comment/insert")
    public String Comment(
        @RequestParam("comment") String comment,
        Model model
    ) {

        UserComment usercomment = new UserComment();
        int seq = userCommentRepository.findAll().size()+1;
        usercomment.setSeq(seq);
        usercomment.setUserComment(comment);

        userCommentRepository.save(usercomment);

        return "redirect:/content";
    }







}
