package com.green.basic;

import java.util.Calendar;

import org.springframework.stereotype.Controller;

@Controller
public class YoilTeller {
	public static void main(String[] args) {
    // 1. �Է�
    String year = args[0];
    String month = args[1];
    String day = args[2];

    int yyyy = Integer.parseInt(year);
    int mm = Integer.parseInt(month);
    int dd = Integer.parseInt(day);

    // 2. ó��
    Calendar cal = Calendar.getInstance();
    cal.set(yyyy, mm - 1, dd);

    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
    char yoil = " �Ͽ�ȭ�������".charAt(dayOfWeek);

    // 3. ���
    System.out.println(year + "�� " + month + "�� " + day + "���� ");
    System.out.println(yoil + "�����Դϴ�.");

    }
}
