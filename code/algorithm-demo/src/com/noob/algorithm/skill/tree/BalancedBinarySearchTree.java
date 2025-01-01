
package com.noob.algorithm.skill.tree;


/**
 * 平衡二叉搜索树（Balanced Binary Search Tree）
 */
public class BalancedBinarySearchTree {

    /**
     * initTreeNode：初始化二叉树
     */
    public static TreeNode initTreeNode() {
        // 定义二叉树节点
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(12);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(10);
        TreeNode node6 = new TreeNode(14);
        TreeNode node7 = new TreeNode(1);
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(7);
        TreeNode node11 = new TreeNode(9);
        TreeNode node12 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node14 = new TreeNode(15);

        // 构建各个节点的关系（构建节点间的引用关系）
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node3.left = node7;
        node3.right = node8;
        node4.left = node9;
        node4.right = node10;
        node5.left = node11;
        node5.right = node12;
        node6.left = node13;
        node6.right = node14;

        // 返回根节点
        return root;
    }


    /**
     * 查找二叉树节点
     *
     * @return
     */
    public static TreeNode search(int target, TreeNode root) {
        // 定义检索指针从根节点开始
        TreeNode cur = root;
        // 循环查找
        while (cur != null) {
            // 将当前节点值和目标值进行比较，如果当前值匹配则检索成功，否则进入左右子树校验
            if (target == cur.val) {
                return cur;
            } else if (target < cur.val) {
                cur = cur.left; // 进入左节点进行比较
            } else if (target > cur.val) {
                cur = cur.right; // 进入右节点进行比较
            }
        }
        return null;
    }


    /**
     * 插入节点
     *
     * @return
     */
    public static TreeNode insert(int target, TreeNode root) {
        // 1.判断根节点是否为null，如果为NULL直接新建节点即可。根节点不为NULL，检索节点插入位置，然后执行插入操作
        if (root == null) {
            return new TreeNode(target);
        }

        // 2.查找插入位置（如果存在重复节点，则不执行任何操作直接返回）
        // 定义检索指针从根节点开始,pre保存上一轮循环的节点
        TreeNode cur = root, pre = null;
        // 循环查找
        while (cur != null) {
            // 将当前节点值和目标值进行比较，如果当前值匹配则检索成功，否则进入左右子树校验
            if (target == cur.val) {
                return root; // 节点重复，不执行任何操作，直接返回原来的root
            }
            // 确认插入位置
            pre = cur; // 保存插入位置的父节点信息
            if (target < cur.val) {
                cur = cur.left; // 进入左节点进行比较
            } else if (target > cur.val) {
                cur = cur.right; // 进入右节点进行比较
            }
        }

        // 3.新建节点进行插入（此时以pre作为父节点进行插入）
        TreeNode node = new TreeNode(target);
        // 根据节点值进行判断插入位置
        if (pre.val < target) {
            pre.right = node; // 插入左边
        } else {
            pre.left = node; // 插入右边
        }
        return root;
    }


    // 删除节点（找到节点位置，然后根据节点的度分情况讨论进行删除）
    public static void remove(int target, TreeNode root) {
        // 判断树是否为空
        if (root == null) {
            return; // 树为空，不执行任何操作
        }

        // 1.树不为空，查找删除节点
        TreeNode cur = root, pre = null;
        while (cur != null) {
            if (cur.val == target) {
                break; // 位置定位成功，直接跳出循环，cur指向当前待删除节点位置
            }
            // 记录上一轮循环的cur节点位置
            pre = cur;
            // 根据值判断从左子树还是右子树进行查找
            if (cur.val > target) {
                cur = cur.left; // 待删除节点在cur的左子树
            } else if (cur.val < target) {
                cur = cur.right; // 待删除节点在cur的右子树
            }
        }

        // 判断待删除节点是否存在，如果不存在则不执行任何操作
        if (cur == null) {
            return;
        }

        // 待删除节点存在，则根据待删除节点的度分情况讨论进行操作

        // 删除节点度为0
        if (cur.left == null && cur.right == null) {
            // 判断删除的是否为root节点
            if (cur != root) {
                // 执行删除操作（根据pre的值进行判断）
                if (pre.left == cur) {
                    pre.left = null; // target在左边，置为null
                } else if (pre.right == cur) {
                    pre.right = null; // target在右边，置为null
                }
            } else {
                // 删除的是根节点
                root = null;
            }
        }

        // 删除节点度为1
        if (cur.left == null || cur.right == null) {
            // 判断删除的是否为root节点
            if (cur != root) {
                // 执行删除操作（根据pre的值进行判断）
                if (pre.left == cur) {
                    pre.left = cur.left; // 将cur的左子树作为pre的左子树
                } else if (pre.right == cur) {
                    pre.right = cur.right; // 将cur的右子树作为pre的右子树
                }
            } else {
                // 删除的是根节点
                root = null;
            }
        }

        // 删除节点度为2
        if (cur.left != null && cur.right != null) {
            // 获取中序遍历中cur的下一个节点(此处找的是右子树的最小节点，即中序遍历的下一个节点)
            TreeNode temp = cur.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            // 递归删除节点temp
            remove(temp.val, root);
            // 用tmp覆盖cur
            cur.val = temp.val;
        }

    }


    public static void main(String[] args) {
//        BalancedBinarySearchTree bsh = new BalancedBinarySearchTree();
//        TreeNode root = bsh.initTreeNode();
//        TreeNode searchRes = bsh.search(5, root);
//        System.out.println("查找结果：" + (searchRes == null ? "null" : searchRes.val));
//
//        // 模拟插入操作
//        bsh.insert(16, root);
//        TreeNode res = bsh.search(16, root);
//        System.out.println("查找结果：" +( res == null ? "null" : res.val));
//
//        // 模拟删除操作
//        bsh.remove(16,root);
//        TreeNode res1 = bsh.search(16, root);
//        System.out.println("删除【16】后：" + (res1 == null ? "null" : res.val));
//        // 模拟删除操作
//        bsh.remove(5,root);
//        TreeNode res2 = bsh.search(5, root);
//        System.out.println("删除【5】后：" + (res2 == null ? "null" : res.val));
    }
}


/**
 * AVL 节点定义
 */
class AVLTreeNode {
    // 定义节点值
    int val;
    // 定义节点高度（该节点到离它最远的节点距离，即所经过的边数量）
    int height;
    // 定义左节点
    AVLTreeNode left;
    // 定义右节点
    AVLTreeNode right;

    // 构造函数
    public AVLTreeNode(int val) {
        this.val = val;
    }

    // 操作工具函数：获取、更新节点高度

    /* 获取节点高度 */
    int height(AVLTreeNode node) {
        // 空节点高度为 -1 ，叶节点高度为 0
        return node == null ? -1 : node.height;
    }

    /* 更新节点高度 */
    void updateHeight(AVLTreeNode node) {
        // 节点高度等于最高子树高度 + 1
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    /* 获取平衡因子 */
    int balanceFactor(AVLTreeNode node) {
        // 空节点平衡因子为 0
        if (node == null)
            return 0;
        // 节点平衡因子 = 左子树高度 - 右子树高度
        return height(node.left) - height(node.right);
    }

    /**
     * AVL 旋转操作分析
     */
    // 右旋操作
    AVLTreeNode rightRotate(AVLTreeNode node) {
        // 定义相关节点（child：旋转原点（node的左节点）、grandchild：child的右节点）
        AVLTreeNode child = node.left;
        AVLTreeNode grandchild = child.right;
        // 执行右旋操作（即将node置于child的右节点位置，child替换原来node的位置）
        child.right = node;
        // 判断grandchild是否为null（如果不为null，需要先将grandchild作为node的左节点）
        node.left = grandchild;
        // 更新节点高度（更新node、child的节点高度）
        updateHeight(node);
        updateHeight(child);
        // 返回旋转后的子树的根节点（此处可以理解为child替换原来node的位置，即传入的是node，右旋返回的是child替换了node的位置）
        return child;
    }


    // 左旋操作
    AVLTreeNode leftRotate(AVLTreeNode node) {
        // 1.定义相关操作节点
        AVLTreeNode child = node.right;
        AVLTreeNode grandchild = child.left;
        // 2.执行左旋操作
        child.left = node; // 将node置于child的左节点
        node.right = grandchild; // 如果存在grandchild，则需将grandchild作为node的右节点
        // 3.更新节点高度（更新node、child的值）
        updateHeight(node);
        updateHeight(child);
        // 返回旋转后的子树的根节点（即旋转原点child，表示其替换了node的位置）
        return child;
    }


    // 旋转操作（执行旋转操作，使子树恢复平衡）
    AVLTreeNode rotate(AVLTreeNode node) {
        // 根据节点的平衡因子进行判断（判断node节点和其对应的子节点的平衡因子，采取相应的旋转方案）

        // 左偏树
        if (balanceFactor(node) > 1) {
            // 判断左节点的平衡因子
            if (balanceFactor(node.left) >= 0) {
                // 执行右旋
                return rightRotate(node);
            } else {
                // 先左旋后右旋(先对子节点左旋，后对node右旋)
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        // 右偏树
        if (balanceFactor(node) < -1) {
            // 判断右节点的平衡因子
            if (balanceFactor(node.right) <= 0) {
                // 执行左旋
                return leftRotate(node);
            } else {
                // 先右旋后左旋(先对子节点右旋，后对node节点左旋)
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }

        }

        // 平衡树（无需旋转，直接返回）
        return node;
    }

    /* 插入节点 */
    /*
    void insert(int val) {
        root = insertHelper(root, val);
    }
     */

    /* 递归插入节点（辅助方法） */
    AVLTreeNode insertHelper(AVLTreeNode node, int val) {
        if (node == null)
            return new AVLTreeNode(val);
        /* 1. 查找插入位置并插入节点 */
        if (val < node.val)
            node.left = insertHelper(node.left, val);
        else if (val > node.val)
            node.right = insertHelper(node.right, val);
        else
            return node; // 重复节点不插入，直接返回
        updateHeight(node); // 更新节点高度
        /* 2. 执行旋转操作，使该子树重新恢复平衡 */
        node = rotate(node);
        // 返回子树的根节点
        return node;
    }

    /* 删除节点 */
    /*
    void remove(int val) {
        root = removeHelper(root, val);
    }
     */

    /* 递归删除节点（辅助方法） */
    AVLTreeNode removeHelper(AVLTreeNode node, int val) {
        if (node == null)
            return null;
        /* 1. 查找节点并删除 */
        if (val < node.val)
            node.left = removeHelper(node.left, val);
        else if (val > node.val)
            node.right = removeHelper(node.right, val);
        else {
            if (node.left == null || node.right == null) {
                AVLTreeNode child = node.left != null ? node.left : node.right;
                // 子节点数量 = 0 ，直接删除 node 并返回
                if (child == null)
                    return null;
                    // 子节点数量 = 1 ，直接删除 node
                else
                    node = child;
            } else {
                // 子节点数量 = 2 ，则将中序遍历的下个节点删除，并用该节点替换当前节点
                AVLTreeNode temp = node.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                node.right = removeHelper(node.right, temp.val);
                node.val = temp.val;
            }
        }
        updateHeight(node); // 更新节点高度
        /* 2. 执行旋转操作，使该子树重新恢复平衡 */
        node = rotate(node);
        // 返回子树的根节点
        return node;
    }


}
