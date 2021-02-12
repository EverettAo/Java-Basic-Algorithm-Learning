package com.atguigu.chessBoard;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Everett
 * @version 1.0
 * @description 骑士周游问题，主要是回溯
 * @date 2/12/2021 7:33 PM
 */
public class ChessBoardAlgorithm {
    private static int X;   // 棋盘的列数
    private static int Y;   // 行数
    private static boolean[] visited;   // 标记位置是否被访问过
    private static boolean finished;    // 标记是否棋盘的所有位置都被访问

    public static void init(int x, int y) {
        X = x;
        Y = y;
        finished = false;
        visited = new boolean[x * y];
    }

    public static void main(String[] args) {
        init(8, 8);
        int row = 1, col = 1;
        int[][] chessBoard = new int[X][Y];
        long start = System.currentTimeMillis();
        System.out.println(start);
        traverse(chessBoard, row - 1, col - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println("共" + (end - start) / 1000 + "秒");
        for (int i = 0; i < chessBoard.length; i++) {
            System.out.println(Arrays.toString(chessBoard[i]));
        }
    }

    /**
     * 骑士周游算法
     *
     * @param chessBoard 棋盘
     * @param row        当前行（0开始计）
     * @param col        当前列（0开始计）
     * @param step       表示走的是第几步
     */
    public static void traverse(int[][] chessBoard, int row, int col, int step) {
        chessBoard[row][col] = step;
        visited[row * X + col] = true;
        ArrayList<Point> ps = next(new Point(col, row));
        sort(ps);
        while (!ps.isEmpty()) {
            Point p = ps.remove(0);
            if (visited[p.y * X + p.x] == false) {
                traverse(chessBoard, p.y, p.x, step + 1);
            }
        }
        if (step < X * Y && finished == false) {
            chessBoard[row][col] = 0;
            visited[row * X + col] = false;
        } else {
            finished = true;
        }
    }

    /**
     * 根据当前的位置（Point对象描述），计算还能走哪些位置，并放入到一个ArrayList中，最多8个位置
     *
     * @param currentPoint
     * @return
     */
    public static ArrayList<Point> next(Point currentPoint) {
        ArrayList<Point> ps = new ArrayList<>();
        Point p = new Point();
        if ((p.x = currentPoint.x - 2) >= 0 && (p.y = currentPoint.y - 1) >= 0) {
            ps.add(new Point(p));
        }
        if ((p.x = currentPoint.x - 1) >= 0 && (p.y = currentPoint.y - 2) >= 0) {
            ps.add(new Point(p));
        }
        if ((p.x = currentPoint.x + 1) < X && (p.y = currentPoint.y - 2) >= 0) {
            ps.add(new Point(p));
        }
        if ((p.x = currentPoint.x + 2) < X && (p.y = currentPoint.y - 1) >= 0) {
            ps.add(new Point(p));
        }
        if ((p.x = currentPoint.x + 2) < X && (p.y = currentPoint.y + 1) < Y) {
            ps.add(new Point(p));
        }
        if ((p.x = currentPoint.x + 1) < X && (p.y = currentPoint.y + 2) < Y) {
            ps.add(new Point(p));
        }
        if ((p.x = currentPoint.x - 1) >= 0 && (p.y = currentPoint.y + 2) < Y) {
            ps.add(new Point(p));
        }
        if ((p.x = currentPoint.x - 2) >= 0 && (p.y = currentPoint.y + 1) < Y) {
            ps.add(new Point(p));
        }
        return ps;
    }

    /**
     * 根据当前这一步的所有下一步的选择位置，进行非递减排序
     */
    public static void sort(ArrayList<Point> ps) {
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return next(o1).size() - next(o2).size();
            }
        });
    }
}
