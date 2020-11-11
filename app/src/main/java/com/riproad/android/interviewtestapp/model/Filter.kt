package com.riproad.android.interviewtestapp.model

import com.riproad.android.interviewtestapp.R

class Filter(private val line: Char) {
    
    fun getImageRes(): Int {
        return when (line) {
            '1' -> {
                R.drawable.line_1
            }
            '2' -> {
                R.drawable.line_2
            }
            '3' -> {
                R.drawable.line_3
            }
            '4' -> {
                R.drawable.line_4
            }
            '5' -> {
                R.drawable.line_5
            }
            '6' -> {
                R.drawable.line_6
            }
            '7' -> {
                R.drawable.line_7
            }
            'A' -> {
                R.drawable.line_a
            }
            'B' -> {
                R.drawable.line_b
            }
            'C' -> {
                R.drawable.line_c
            }
            'D' -> {
                R.drawable.line_d
            }
            'E' -> {
                R.drawable.line_e
            }
            'F' -> {
                R.drawable.line_f
            }
            'G' -> {
                R.drawable.line_g
            }
            'J' -> {
                R.drawable.line_j
            }
            'L' -> {
                R.drawable.line_l
            }
            'M' -> {
                R.drawable.line_m
            }
            'N' -> {
                R.drawable.line_n
            }
            'Q' -> {
                R.drawable.line_q
            }
            'R' -> {
                R.drawable.line_r
            }
            'S' -> {
                R.drawable.line_s
            }
            'V' -> {
                R.drawable.line_v
            }
            'W' -> {
                R.drawable.line_w
            }
            'Z' -> {
                R.drawable.line_z
            }
            else -> 0
        }
    }
}