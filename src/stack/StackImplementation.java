package stack;

public class StackImplementation {
	private static final int STACK_SIZE = 10;
	private static int [] stack = new int [STACK_SIZE];
	private static int tos = -1;

	public static void main(String [] args){
		push(stack, 1);
		push(stack, 2);
		push(stack, 3);
		push(stack, 4);
		push(stack, 5);
		push(stack, 6);
//		display(stack);
		System.out.println(pop());
	}
	
	public static void push(int [] stack, int value){
		if (tos == STACK_SIZE - 1){
			System.out.println("stack is full");
		}else{
			stack[++tos] = value;
		}
	}
	
	public static int pop(){
		if (tos < 0){
			System.out.println("stack is empty");
			return -1;
		}else{
			return stack[tos--];
		}
	}
	
	public  void display(int [] stack){
		for (int i = 0; i < STACK_SIZE; i++){
			System.out.print(pop()+",");
		}
	}
}