package stackAndQueue;
/*  
 * Describe how you could use a single array to implement three stacks.
 */
public class SinglyArrayForThreeStacks {

	public static void main(String args[]){
		SinglyArrayForThreeStacks stack = new SinglyArrayForThreeStacks();
		for(int i = 0; i < 30 ; i++){
			stack.push(i % 3, i);
		}
		
		for(int i = 0; i < 10; i++){
			System.out.print(stack.pop(0)+" ");
			System.out.print(stack.pop(1)+" ");
			System.out.print(stack.pop(2)+"\n");
		}
	}
	
	class StackNode{
		int previous;
		int value;
		public StackNode(int previous, int value){
			this.previous = previous;
			this.value = value;
		}
	}
	
	int indexUsed = 0;
	int[] stackPointer = {-1, -1, -1};
	int stackSize = 300;
	StackNode[] buffer = new StackNode[stackSize * 300];
	
	public void push(int stackNum, int value){
		int last = stackPointer[stackNum];
		stackPointer[stackNum] = indexUsed;
		buffer[stackPointer[stackNum]] = new StackNode(last, value);
                indexUsed++;
	}
	
	public int pop(int stackNum){
		int preIndex = buffer[stackPointer[stackNum]].previous;
		int value = buffer[stackPointer[stackNum]].value;
		buffer[stackPointer[stackNum]] = null;
		stackPointer[stackNum] = preIndex;
		indexUsed--;
		return value;
	}
	
	public int peep(int stackNum){
		return buffer[stackPointer[stackNum]].value;
	}
	
	public boolean isEmpty(int stackNum){
		return stackPointer[stackNum] == -1;
	}
}

