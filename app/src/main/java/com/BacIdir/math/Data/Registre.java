package com.BacIdir.math.Data;

import android.content.SharedPreferences;

import androidx.recyclerview.widget.RecyclerView;

import com.BacIdir.math.R;

public abstract class Registre {

    public static String [] unitsTitles = {"الدوال","المتتاليات","الاعداد المركبة","الهندسة في الفضاء","الاحتمالات","تقييمك"};
    public static int currentUnit = 0 ;
    public static int currentExo = 0;
    public static int lockedQuestColor ;
    public static int unlockedQuestColor ;
    public static SharedPreferences sharedPreferences ;
    public static int SCREEN_WIDTH ;
    public static int SCREEN_HEIGHT ;
    public static RecyclerView recyclerView;

    // Counter select mode and countdown mode
    public static String [] Lmin = {"10","15","20","25","30","35","40","45","50","55","60"};
    public static String [] Rmin = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26",
            "27","28","29","30", "31", "32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56",
            "57","58","59","60"};

    // Units Exos
    public static int[] Unit1 = {R.drawable.exo,R.drawable.exo6,R.drawable.exo10,R.drawable.exo15,R.drawable.exo19,R.drawable.exo31,
            R.drawable.exo35,R.drawable.exo39,R.drawable.exo43,R.drawable.exo44,R.drawable.exo49,R.drawable.exo53,R.drawable.exo56,R.drawable.exo60,R.drawable.exo64,
            R.drawable.exo68,R.drawable.exo72,R.drawable.exo75,R.drawable.exo77};
    public static int[] Unit2 = {R.drawable.exo3,R.drawable.exo7,R.drawable.exo11,R.drawable.exo12,R.drawable.exo13,R.drawable.exo17,R.drawable.exo22,R.drawable.exo26,
            R.drawable.exo30,R.drawable.exo37,R.drawable.exo41,R.drawable.exo46,R.drawable.exo51,R.drawable.exo57,R.drawable.exo61,R.drawable.exo66,R.drawable.exo69,
            R.drawable.exo71,R.drawable.exo78,R.drawable.exo81};
    public static int[] Unit4 =  {R.drawable.exo2,R.drawable.exo4,R.drawable.exo8,R.drawable.exo18,R.drawable.exo20,R.drawable.exo24,R.drawable.exo28,
            R.drawable.exo32,R.drawable.exo36,R.drawable.exo40,R.drawable.exo45,R.drawable.exo47,R.drawable.exo50,R.drawable.exo58,R.drawable.exo76,R.drawable.exo42,
            R.drawable.exo82};
    public static int[] Unit3 = {R.drawable.exo1,R.drawable.exo5,R.drawable.exo9,R.drawable.exo14,R.drawable.exo16,R.drawable.exo25,R.drawable.exo29,R.drawable.exo33,
            R.drawable.exo38,R.drawable.exo80,R.drawable.exo48,R.drawable.exo52,R.drawable.exo55,R.drawable.exo59,R.drawable.exo63,R.drawable.exo67,R.drawable.exo83};
    public static int[] Unit5 =  {R.drawable.exo54,R.drawable.exo62,R.drawable.exo65,R.drawable.exo70,R.drawable.exo73,R.drawable.exo74,R.drawable.exo79};


    // Units Hints
    public static int[] Unith1 = {R.drawable.h4,R.drawable.h5,R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,R.drawable.h11,R.drawable.h12};
    public static int[] Unith2 = {R.drawable.h13};
    public static int[] Unith4 = {R.drawable.h14,R.drawable.h15,R.drawable.h16,R.drawable.h17,R.drawable.h18,R.drawable.h19,R.drawable.h20,R.drawable.h21,
            R.drawable.h22, R.drawable.h23,R.drawable.h24,R.drawable.h25,R.drawable.h26,R.drawable.h27,R.drawable.h28,R.drawable.h29};
    public static int[] Unith3 = {R.drawable.h30,R.drawable.h31,R.drawable.h32,R.drawable.h33,R.drawable.h34,R.drawable.h35,R.drawable.h36,R.drawable.h37,
            R.drawable.h38, R.drawable.h39,R.drawable.h40,R.drawable.h41,R.drawable.h42};
    public static int[] Unith5 =   {R.drawable.h1,R.drawable.h2,R.drawable.h3};

    // Units Solutions
    public static int[] Units1 = {R.drawable.s41,R.drawable.s7,R.drawable.s23,R.drawable.s39,R.drawable.s64,R.drawable.s42,R.drawable.s15,
            R.drawable.s43,R.drawable.s44,R.drawable.s73,R.drawable.s47,R.drawable.s45,R.drawable.s48,R.drawable.s32,R.drawable.s35,R.drawable.s89,R.drawable.s93};
    public static int[] Units2 =  {R.drawable.s49,R.drawable.s9,R.drawable.s21,R.drawable.s37,R.drawable.s25,R.drawable.s86,R.drawable.s62,R.drawable.s2,
            R.drawable.s12,R.drawable.s66,R.drawable.s71,R.drawable.s26,R.drawable.s33,R.drawable.s31,R.drawable.s28,R.drawable.s21,
            R.drawable.s94,R.drawable.s87,R.drawable.s34};
    public static int[] Units4 = {R.drawable.s50,R.drawable.s8,R.drawable.s16,R.drawable.s38,R.drawable.s40,R.drawable.s51,R.drawable.s3,R.drawable.s82,
            R.drawable.s88 ,R.drawable.s65, R.drawable.s52,R.drawable.s53,R.drawable.s29,R.drawable.s54,R.drawable.s18,R.drawable.s22,R.drawable.s55};
    public static int[] Units3 = {R.drawable.s80,R.drawable.s56,R.drawable.s57,R.drawable.s17,R.drawable.s36,R.drawable.s58,R.drawable.s59,R.drawable.s60,
            R.drawable.s81,R.drawable.s69,R.drawable.s68,R.drawable.s67,R.drawable.s72,R.drawable.s70,R.drawable.s61,R.drawable.s11,R.drawable.s63};
    public static int[] Units5 = {R.drawable.s30,R.drawable.s75,R.drawable.s92,R.drawable.s4,R.drawable.s74,R.drawable.s1,R.drawable.s27 };


    // Units
    public static int [][] Units = {Unit1,Unit2,Unit3,Unit4,Unit5};
    public static int [][] Hints = {Unith1,Unith2,Unith3,Unith4,Unith5};
    public static int [][] Solutions = {Units1,Units2,Units3,Units4,Units5};
    public static int [] UnitsProgress = new int[5];
    public static String [] UnitsProgressKeys = {"Unit1Progress","Unit2Progress","Unit3Progress","Unit4Progress","Unit5Progress"};

}
