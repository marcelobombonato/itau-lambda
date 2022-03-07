package br.com.lambda;

import java.util.HashMap;
import java.util.Map;

public class mainapp {

	public static void main(String[] args) {
		DecryptLambda lb = new DecryptLambda();
		
		Map<String, String> map = new HashMap<>();
		
		map.put("iso_message", "JqYb0cyPp99wZ7bSLL6dJ7Y3Gks4AzFrJJv3w7hIAoyNGzyFevkmFkoqrgm0Wwf1TLo2A7eSCIDJpEX5ygyinHCJndVnlTMHrVTdmBAuR3zMtky8uqUMHvxIaK80NNJl2iKT+7UGUkHl/H+MI8qfiDwctldGsido4udL2l+6jHgW98yoQ29pUEKf3phMcq0/zV/eype3Nbegw0fI+JDgX2YX7L6EemlTU8OPPes+LQhtnNlW4/mosM4jBno3zuuJd0oL3JlcJpjn5sbX/VrUP/GnGNFX4DLSXQTJggzZoRK1g+oZchyKq+cFBJtnCGa9BK+H7RmgI5/ABPFs9xj1YXVhzopTLPYqRWeWJSOkejMp+jb4mtIlmaEpuglxcYpCKb0a0ZzsyRZZOHXr86iwNG3tVo1ZVhtvth9aoR2CGRBihit5FE8uxnCJS/0D7FE6tY4iqtDIsaUZjccJe9QhnHjn9mUklODoAaNpShzcpwGsKRt+kXKn71IJ8+vJFmR9");
		
		lb.handleRequest(map, null);
	}

}
