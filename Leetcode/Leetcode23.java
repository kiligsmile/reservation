class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        MinHeap heap = new MinHeap(lists.length);
        // 1. 将链表的头节点加入小顶堆
        for (ListNode h : lists) {
            if(h != null) {
                heap.offer(h);
            }
        }
        // 2. 不断从堆顶移除最小元素, 加入新链表
        ListNode s = new ListNode(-1, null);
        ListNode t = s;
        while(!heap.isEmpty()) {
            ListNode min = heap.poll();
            t.next = min;
            t = min;
            // 将最小元素的下一个节点加入到堆
            if(min.next != null) {
                heap.offer(min.next);
            }
        }
        return s.next;

    }
    static public class MinHeap {
        ListNode[] array;
        int size;

        public MinHeap(int capacity) {
            array = new ListNode[capacity];
        }

        public boolean offer(ListNode offered) {
            if (isFull()) {
                return false;
            }
            int child = size++;
            int parent = (child - 1) / 2;
            while (child > 0 && offered.val < array[parent].val) {
                array[child] = array[parent];
                child = parent;
                parent = (child - 1) / 2;
            }
            array[child] = offered;
            return true;
        }

        public ListNode poll() {
            if (isEmpty()) {
                return null;
            }
            swap(0, size - 1);
            size--;
            ListNode e = array[size];
            array[size] = null; // help GC

            // 下潜
            down(0);

            return e;
        }

        private void down(int parent) {
            int left = 2 * parent + 1;
            int right = left + 1;
            int min = parent; // 假设父元素最小
            if (left < size && array[left].val < array[min].val) {
                min = left;
            }
            if (right < size && array[right].val < array[min].val) {
                min = right;
            }
            if (min != parent) { // 有孩子比父亲小
                swap(min, parent);
                down(min);
            }
        }

        private void swap(int i, int j) {
            ListNode t = array[i];
            array[i] = array[j];
            array[j] = t;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == array.length;
        }
    }

}