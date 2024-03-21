package user;

import com.test.grpc.User.APIResponse;
import com.test.grpc.User.Empty;
import com.test.grpc.User.LoginRequest;
import com.test.grpc.userGrpc.userImplBase;

import io.grpc.stub.StreamObserver;;

public class UserService extends userImplBase {

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
		
		System.out.println("Inside login");
		String username=request.getUsername();
		String password=request.getPassword();
		
		APIResponse.Builder response= APIResponse.newBuilder();
		if(username.equals(password)) {
			
			//return success message
			response.setResponseCode(0).setResponsemessage("Success");
		}
		else {
			
			// return failure message
			response.setResponseCode(100).setResponsemessage("Invalid Password");	
		}
		
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
		
	}

	
}
