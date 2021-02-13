package com.atguigu.tree.huffmanTree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

/**
 * @Bug 解码最后一个字节的时候偶尔会出bug
 */

class BNode implements Comparable<BNode> {
    Integer weight; // 权重，字符出现的次数
    BNode left, right;
    Byte data;   // 字符对应的ascii码，如'a' == 97

    public BNode(Integer i) {
        this.weight = i;
    }

    @Override
    public int compareTo(BNode o) {
        return this.weight - o.weight;
    }

    public BNode(Byte data, Integer weight) {
        this.weight = weight;
        this.data = data;
    }

    @Override
    public String toString() {
        return "BNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
}

public class HuffmanCoding {
    /**
     * 思路：
     * 编码：
     * 从原始字符串得到其对应的byte[]；用该byte[]构建huffman树，byte为节点data，出现的次数为weight
     * 从huffman树构建对应的编码表；用该编码表对原始byte[]编码成01字符串；更进一步，将该01串重新正常解码为byte[]——得到长度变短的byte[]
     * 解码：
     * 用编码表对压缩后的byte[]解码为01字符串
     * 注意事项：压缩时，对最后一个字符，没有补位压缩，所以解码时也要注意，因为计算机中存储的是补码
     * 将01字符串正常解码为byte[]，byte[]转化为对应的char
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "but if you wanna cry, cry on my shoulder, if you need someone who cares for you";
        byte[] strBytes = str.getBytes();
        System.out.println("原长度：" + strBytes.length);
        for (byte b :
                strBytes) {
            System.out.print(b);
        }
        System.out.println();
        List<BNode> nodes = getNodes(strBytes);
        System.out.println(nodes);
        BNode root = createHuffmanTree(nodes);
        preOrder(root);
        HashMap<Byte, String> codeMap = createHuffmanCodeMap(root);
        System.out.println(codeMap);
        byte[] zipBytes = huffmanZip(strBytes);
        System.out.println("压缩后：" + Arrays.toString(zipBytes));
        System.out.println("长度为：" + zipBytes.length);
        byte[] sourceBytes = decode(huffmanCodesMap, zipBytes);
        System.out.println(new String(sourceBytes));

/*        String srcFile = "E:\\Everett\\Pictures\\打印流.png";
        String destFile = "E:\\Everett\\Pictures\\打印流.zip";
        String unzipFile = "E:\\Everett\\Pictures\\unzip.png";
        fileZip(srcFile, destFile);
        fileUnzip(destFile, unzipFile);*/
    }

    public static void preOrder(BNode tree) {
        if (tree != null) {
            System.out.println(tree);
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public static List<BNode> getNodes(byte[] bytes) {
        ArrayList<BNode> nodeArrayList = new ArrayList<>();
        /**
         * 存储每个byte出现的次数
         */
        Map<Byte, Integer> map = new HashMap<Byte, Integer>();
        for (byte b : bytes) {
            Integer count = map.get(b);
            if (count == null) {
                map.put(b, 1);
            } else {
                map.put(b, count + 1);
            }
        }
        /**
         * 将键值对装成一个BNode对象
         */
        // 遍历map
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            nodeArrayList.add(new BNode(entry.getKey(), entry.getValue()));
        }
        return nodeArrayList;
    }

    public static BNode createHuffmanTree(List<BNode> nodes) {
        BNode leftNode, rightNode;
        while (nodes.size() > 1) {
            Collections.sort(nodes); // 默认从小到大排
            leftNode = nodes.get(0);
            rightNode = nodes.get(1);
            BNode parent = new BNode(leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    /**
     * 生成赫夫曼编码表
     * 思路：
     * 1. 将表放在String类型的map中
     * 2. 在生成编码表时，需要拼接路径，所以定义一个StringBuilder来存储叶子节点的路径
     */
    static HashMap<Byte, String> huffmanCodesMap = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();

    /**
     * @return void
     * @description 将传入的node节点的所有叶子节点的huffman编码存放到huffmanCodesMap中；
     * @params [node, code, stringBuilder] 传入的节点（默认根节点）；路径值（eg：左0右1）;用stringbuilder构建路径
     * @author Everett
     * @time 1/27/2021 5:57 PM
     */
    public static void getCodes(BNode node, String code, StringBuilder stringBuilder) {
        StringBuilder temp = new StringBuilder(stringBuilder);
        temp.append(code);
        if (node != null) {
            if (node.data == null) {
                // 非叶子节点，递归处理
                getCodes(node.left, "0", temp);
                getCodes(node.right, "1", temp);
            } else {
                // 叶子节点
                huffmanCodesMap.put(node.data, temp.toString());
            }
        }
    }

    /**
     * 为了调用方便，重载getCodes
     */
    public static HashMap<Byte, String> createHuffmanCodeMap(BNode root) {
        if (root != null) {
            getCodes(root, "", stringBuilder);
            return huffmanCodesMap;
        } else {
            return null;
        }
    }

    /**
     * 通过编码表，从字符串对应的byte数组得到压缩后的byte数组
     * 1. 原始字符串 -> 原始字符串对应的byte[]
     * 2. 原始byte[] -> 二进制字符串
     * 3. 二进制字符串 -> huffmanByte[]，即从8位二进制得到一byte其对应的数字
     * <p>
     * 注意事项：二进制到位的转换涉及到计算机中值的存储：存原码。不过正数三码合一、负数存补码
     */
    private static byte[] zip(byte[] origin, HashMap<Byte, String> codeMap) {
        /**
         * 1. 利用huffman编码表将传进来的字节数组转成huffman编码对应的字符串
         * 2.
         */
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : origin) {
            stringBuilder.append(codeMap.get(b));
        }
        int len = (stringBuilder.length() + 7) / 8;
        // 创建存储压缩后的byte数组
        byte[] hufffBytes = new byte[len];
        String stringByte;
        int index = 0; // 记录是第几个byte
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            if (i + 8 > stringBuilder.length()) {
                stringByte = stringBuilder.substring(i); // 从i到末尾
            } else {
                stringByte = stringBuilder.substring(i, i + 8);
            }
            hufffBytes[index++] = (byte) Integer.parseInt(stringByte, 2); // 按二进制转
        }
        return hufffBytes;
    }

    /**
     * 将上述过程进行封装，以方便调用
     */
    private static byte[] huffmanZip(byte[] originByte) {
        List<BNode> nodes = getNodes(originByte);
        BNode root = createHuffmanTree(nodes);
        HashMap<Byte, String> codeMap = createHuffmanCodeMap(root);
//        System.out.println(codeMap);
        byte[] zipBytes = zip(originByte, codeMap);
        return zipBytes;
    }
    /******************************解码数据****************************/
    /**
     * 1. 将压缩后的byte[] -> 01字符串
     * 2. 将01字符串 -> 原始字符串
     *
     * @param b    传入的byte
     * @param flag 是否需要补齐高位
     * @return 按补码返回的该byte对应的二进制字符串
     */
    private static String byte2BitString(byte b, boolean flag) {
        /**
         * 使用变量保存b
         */
        int temp = b;
        /**
         * 1. 从整数转二进制，存在问题：长度是按照整数来的，可以截取字符串最后8位来解决
         * 2. 仍然存在问题：如果是正数，其长度就是值的实际二进值值的长度，可能不足8，需要补位
         */
        if (flag) {
            temp |= 256;
            String intStr = Integer.toBinaryString(temp); //temp对应的二进制的补码
            return intStr.substring(intStr.length() - 8); // 只返回最后的8位，即byte对应的二进进制位
        } else {
            return Integer.toBinaryString(temp);
        }
    }

    /**
     * 从压缩后的byte[]，利用对应的huffmanCodeMap，还原出原始内容的byte[]
     *
     * @param huffmanCodesMap 编码表
     * @param huffmanBytes    压缩后的byte[]
     * @return
     */
    public static byte[] decode(Map<Byte, String> huffmanCodesMap, byte[] huffmanBytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < huffmanBytes.length; i++) {
            /**
             * 最后一个字节不需要补高位。因为在压缩的时候，最后一位并没有补满8位
             */
            boolean flag = (i != huffmanBytes.length - 1);
            stringBuilder.append(byte2BitString(huffmanBytes[i], flag));
        }

        /**
         * 把二进制字符串按照huffman编码表进行解码
         * 需要把huffman编码表的k-v进行调换
         */
        HashMap<String, Byte> stringByteHashMap = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodesMap.entrySet()) {
            stringByteHashMap.put(entry.getValue(), entry.getKey());
        }
        /**
         * 创建集合存放byte
         */
        ArrayList<Byte> list = new ArrayList<>();
        /**
         * 遍历stringBuilder，看看编码表里面有没有，有就放到list里面，没有就继续扫描
         */
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1; // 小的计数器
            Byte b = null;
            boolean flag = true;
            /**
             * i只走一圈，count在小区间内移动计数
             */
            while (flag) {
                // 取出一位
                String key = stringBuilder.substring(i, i + count);
                // 尝试取出key对应的value
                b = stringByteHashMap.get(key);
                if (b != null) {
                    flag = false; // 退出while循环
                } else {
                    count++;
                }
            }
            list.add(b);
            i += count;
        }
        byte[] res = new byte[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 将文件进行压缩
     *
     * @param srcFile  原始文件的位置
     * @param destFile 压缩后文件的位置
     */
    public static void fileZip(String srcFile, String destFile) {
        // 创建输入输出流
        FileInputStream is = null;
        FileOutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            // 创建文件输入流
            is = new FileInputStream(srcFile);
            byte[] b = new byte[is.available()];
            // 将文件内容读取到byte数组中
            is.read(b);
            // 对文件内容进行编码
            byte[] huffmanZipBytes = huffmanZip(b);
            // 创建文件的输出流，存放压缩后的文件
            os = new FileOutputStream(destFile);
            // 创建一个和文件关联的ObjectOutputStream
            oos = new ObjectOutputStream(os);
            // 把huffman编码的字节数组写入压缩文件
            oos.writeObject(huffmanZipBytes);
            // 以对象流的方式写入huffman编码后的内容，方便以后恢复源文件使用
            // 注意：一定要把huffman编码写入压缩文件，不然以后无法恢复
            oos.writeObject(huffmanCodesMap);
            // 注意：codesmap在压缩的时候已经拿到了
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
                oos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void fileUnzip(String zipFile, String dstFile) {
        FileInputStream is = null;
        FileOutputStream os = null;
        ObjectInputStream ois = null;
        try {
            is = new FileInputStream(zipFile);
            ois = new ObjectInputStream(is);
            byte[] huffmanBytes = (byte[]) ois.readObject();
            HashMap<Byte, String> huffmanCodeMap = (HashMap<Byte, String>) ois.readObject();
            byte[] unzipBytes = decode(huffmanCodeMap, huffmanBytes);
            os = new FileOutputStream(dstFile);
            os.write(unzipBytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                ois.close();
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}