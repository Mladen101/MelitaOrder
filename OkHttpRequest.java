package postman;




import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import okhttp3.Request;
import okhttp3.Response;

@Getter @Setter @NoArgsConstructor
@Builder @AllArgsConstructor
public class OkHttpRequest {
  private Request request;
  private Response response;
  private Response execute;

  void add() {};
  void builder() {};
	void request() {};
	void build(){};


}
