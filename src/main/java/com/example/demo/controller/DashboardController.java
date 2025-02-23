package com.example.demo.controller;


import com.example.demo.domain.Member;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        Member member = (Member) session.getAttribute("loginMember");

        if (member == null) {
            return "redirect:/members/login"; // 로그인되지 않은 경우 다시 로그인 페이지로 이동
        }

        model.addAttribute("email", member.getEmail());
        model.addAttribute("nickname", member.getNickname());

        return "dashboard"; // templates/dashboard.html
    }
}
