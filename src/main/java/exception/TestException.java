package exception;

public class TestException {
	public void Test() throws ReferenceException {
		throw new ReferenceException("referenced code", "referenced value");
	}
}