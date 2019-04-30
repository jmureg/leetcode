package arrays;

public class CircularArray {
    int size;
    byte[] data;
    int front;
    int rear;

    CircularArray(int size) {
        this.size = size;
        this.data = new byte[this.size];
        this.front = -1;
        this.rear = -1;
    }

    public static void main(String[] args) {
        CircularArray ca = new CircularArray(10);

        ca.enqueueN(new byte[]{0, 1, 2, 3, 4});
        ca.print();
        ca.enqueueN(new byte[]{5, 6, 7, 8, 9});
        ca.print();
        ca.enqueueN(new byte[]{1});
        ca.print();
        ca.dequeueN(3);
        ca.print();
        ca.enqueueN(new byte[]{'a', 'b', 'c', 'd'});
        ca.print();
        ca.dequeueN(3);
        ca.print();
        ca.enqueueN(new byte[]{'x', 'y', 'z'});
        System.out.println();

    }

    public int enqueueN(byte[] data) {
        int amount = 0;
        for (byte entry : data
        ) {
            if (enqueue(entry)) {
                amount++;
            } else {
                break;
            }
        }

        return amount;
    }

    public boolean enqueue(byte input) {
        if ((this.front == 0 && this.rear == this.size - 1) || (this.rear == (this.front % this.size - 1))) {

            return false;
        } else if (this.rear == -1) {
            this.rear = 0;
            this.front = 0;
            this.data[this.front] = input;

            return true;
        } else if (this.rear == this.size - 1 && this.front != 0) {
            this.rear = 0;
            this.data[this.rear] = input;

            return true;
        } else {
            this.rear++;
            this.data[this.rear] = input;

            return true;
        }
    }

    public byte[] dequeueN(int n) {
        byte[] ans = new byte[n];
        for (int i = n - 1; i >= 0; i--) {
            ans[n - i - 1] = dequeue();
        }

        return ans;
    }

    private byte dequeue() {
        if (this.front == -1 && this.rear == -1) {

            return 0;
        } else if (this.front != -1 && this.rear > this.front) {
            byte ans = this.data[this.front];
            this.data[this.front] = 0;

            if (this.front == this.size - 1) {
                this.front = 0;
            } else {
                this.front++;
            }

            return ans;
        } else if (this.front + 1 < this.size - 1) {
            byte ans = this.data[this.front];
            this.data[this.front] = 0;
            this.front++;

            return ans;
        } else if (this.front + 1 == this.size - 1) {
            byte ans = this.data[this.front];
            this.front = 0;

            return ans;
        }

        return 0;
    }

    public void print() {
        System.out.println("---print---");
        for (byte entry : this.data
        ) {
            System.out.print("\t" + entry);
        }
        System.out.println();
        System.out.println("--fin.");
        System.out.println();
    }
}
