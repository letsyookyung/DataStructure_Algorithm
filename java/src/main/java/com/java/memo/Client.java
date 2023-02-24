public class Client {
	public static void main(String[] args) {
		// java의 for문을 사용하면
		MyCollection c = new MyCollection();
		for (Integer i : c) {
			System.out.println(i);
		}

		// Iterator 패턴을 직접 사용하면, java for도 내부적으로는 아래처럼
		MyCollection c = new MyCollection();
		Iterator<C> iter = c.iterator(); // CreateIterator

		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		// 그러면 MyCollection 클래스는 어떻게 만들어야 하는가?

	}
}

