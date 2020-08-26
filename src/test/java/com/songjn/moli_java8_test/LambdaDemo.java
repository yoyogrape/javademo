//package com.songjn.moli_java8_test;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
///**
// * @auther songjn1
// * @create 2019-03-22
// * @desc
// */
//public class LambdaDemo {
//    private List<Button> buttons = Arrays.asList(
//            new Button(1L, "button01", "Yes"),
//            new Button(2L, "button02", "No"),
//            new Button(3L, "button03", "HelpFul"),
//            new Button(4L, "button04", "UnHelpFul")
//    );
//
//    public String demo01(Turn turn) throws Exception {
//        if (turn != null) {
//            if (turn.getDmResult() != null) {
//                DMResult dmResult = turn.getDmResult();
//                if (dmResult.getUserId() != null) {
//                    return dmResult.getUserId();
//                }
//            }
//        }
//        throw new RuntimeException("取值错误");
//    }
//
//    @Test
//    public void demo02() throws Exception {
//        Turn turn = null;
//        final String ss = Optional.ofNullable(turn)
//                .map(t -> t.getDmResult())
//                .map(dr -> dr.getUserId())
//                .orElse("haha");
//        System.out.println(ss);
//    }
//
//    @Test
//    public void demo06(List<Button> buttonList) {
//
//        for (Button button : buttonList) {
//            System.out.println(button.toString());
//        }
//
//    }
//
//    public void demo07(List<Button> buttonList) {
//        buttonList.forEach(System.out::println);
//    }
//
//    public String demo03(Button button) throws Exception {
//        String name = button.getShowName();
//        if (button.getShowName() == null) {
//            name = button.getName();
//        }
//        return name;
//    }
//
//    public String demo04(Button button) throws Exception {
//        return Optional.ofNullable(button)
//                .map(bt -> bt.getShowName())
//                .orElse(button.getName());
//
//    }
//
//    @Test
//    public void demo08() {
//        for (Button button : buttons) {
//            if ("button04".equals(button.getName())) {
//                button.setShowName(button.getName());
//            }
//        }
//
//
//        buttons.forEach(System.out::println);
//
//    }
//
//    @Test
//    public void demo09() {
//        buttons.stream().map(bt -> {
//            if ("button04".equals(bt.getName())) {
//                bt.setShowName(bt.getName());
//            }
//            return bt;
//        }).collect(Collectors.toList());
//
//        buttons.forEach(System.out::println);
//    }
//
//    @Test
//    public void demo10() {
//        final ArrayList<String> strings = new ArrayList<>();
//        for (Button button : buttons) {
//            final String s = button.getName().replaceAll("\\d", "");
//            strings.add(s);
//        }
//        strings.forEach(System.out::println);
//    }
//
//    @Test
//    public void demo11() {
//        buttons.stream().map(bt -> bt.getName().replaceAll("\\d", ""))
//                .collect(Collectors.toList())
//                .forEach(System.out::println);
//    }
//}
