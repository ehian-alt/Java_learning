# 数组 Array

* 数组声明: `dataType[] arrayName;`
* 创建数组: `arrayName = new dataType[arraySize];`
* 声明和创建可以用一条语句完成: `dataType[] arrayName = new dataType[arraySize];`
* 还可以直接创建: `dataType[] arrayName = {value0, value1, ..., valuek};`

### 数组的遍历

* 用索引遍历 / 不用索引 (foreach) 遍历
```java
public class Array_ {
    public static void main(String[] args){
        // 用索引遍历
        char[] ch_array = {'h', 'e', 'l', 'l', 'o'};
        for ( int i = 0; i < ch_array.length; i++ ){
            System.out.print(ch_array[i] + " ");
        }
        System.out.println();
        // foreach 遍历
        for (char c: ch_array) {
            System.out.print(c + " ");
        }
    }
}
```

运行结果如下:

    h e l l o
    h e l l o 

### 多维数组

* 二维数组的创建: `type[][] typeName = new type[typeLength1][typeLength2];`
* 从最高维开始，分别为每一维分配空间，例如:

      String[][] s = new String[2][];
      s[0] = new String[2];
      s[1] = new String[3];
  s[0].length = 2  
  s[1].length = 3

### Arrays类及方法
* 给数组赋值：通过 fill 方法。 `public static void fill(int[] a, int val)`
  * 将指定的 int 值分配给指定 int 型数组指定范围中的每个元素。同样的方法适用于所有的其他基本数据类型（Byte，short，Int等）
* 对数组排序：通过 sort 方法,按升序。 `public static void sort(Object[] a)`
  * 对指定对象数组根据其元素的自然顺序进行升序排列。同样的方法适用于所有的其他基本数据类型（Byte，short，Int等）
* 比较数组：通过 equals 方法比较数组中元素值是否相等。 `public static boolean equals(Object[] a, Object[] a2)`
  * 如果两个数组以相同顺序包含相同的元素，则两个数组是相等的。同样的方法适用于所有的其他基本数据类型（Byte，short，Int等）
* 查找数组元素：通过 binarySearch 方法能对排序好的数组进行二分查找法操作。 `public static int binarySearch(Object[] a, Object key)`
  * 用二分查找算法在给定数组中搜索给定值的对象(Byte,Int,double等)。数组在调用前必须排序好的。如果查找值包含在数组中，则返回搜索键的索引；否则返回 (-(插入点) - 1)。

```java
public class Array_ {
    public static void main(String[] args){
      // fill
      int[] intArray = new int[5];
      Arrays.fill(intArray, 0);
      System.out.println(Arrays.toString(intArray));
      // sort
      int[] intArray_2 = {1, 3, 2, 6, 4, 4, 5};
      Arrays.sort(intArray_2);
      System.out.println(Arrays.toString(intArray_2));
      // equals
      System.out.println(Arrays.equals(intArray, intArray_2));
      // binarySearch
      System.out.println(Arrays.binarySearch(intArray_2, 4));
    }
}
```

运行结果如下:

    [0, 0, 0, 0, 0]
    [1, 2, 3, 4, 4, 5, 6]
    false
    3