package com.tranquyet.controller;


import org.springframework.stereotype.Controller;

@Controller
public class AppController {
//    @GetMapping("/login")
//    public String login(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if(authentication == null || authentication instanceof AnonymousAuthenticationToken){
//            return "login";
//        }
//        return "redirect:/list";
//    }
//
//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request, HttpServletResponse response){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Optional<Authentication> checkAuthentication = Optional.of(authentication);
//        checkAuthentication.ifPresent(p->{
//            new SecurityContextLogoutHandler().logout(request, response, p);
//        });
//        return "redirect:/login?logout";
//    }


}
