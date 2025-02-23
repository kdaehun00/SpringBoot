package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Model 임포트 수정
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/login")
    public String login() {
        return "members/login"; // templates/members/login.html
    }

    @PostMapping("/members/login")
    public String login(String email, String password, Model model, HttpSession session) {
        System.out.println("로그인 시도 이메일: " + email);

        Member member = memberService.login(email, password);
        if (member != null) {
            session.setAttribute("loginMember", member);
            System.out.println("로그인 성공: " + member.getNickname());
            System.out.println("세션에 저장된 회원: " + session.getAttribute("loginMember"));

            return "redirect:/dashboard";
        } else {
            System.out.println("로그인 실패: 이메일 또는 비밀번호가 잘못되었습니다.");
            model.addAttribute("error", "이메일 또는 비밀번호가 잘못되었습니다.");
            return "members/login"; // "members/login" 경로를 정확히 설정
        }
    }


    @GetMapping("/members/signup")
    public String signup() {
        return "members/signup"; // templates/members/signup.html
    }

    @PostMapping("/members/signup")
    public String signupForm(MemberForm memberform) {
        Member member = new Member();
        BeanUtils.copyProperties(memberform, member);
        memberService.join(member);
        return "redirect:/members/login";
    }
}
