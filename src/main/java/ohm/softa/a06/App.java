package ohm.softa.a06;

import ohm.softa.a06.model.Joke;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
public class App {

	public static void main(String[] args) throws IOException {
		Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("https://api.chucknorris.io/")
			.addConverterFactory(GsonConverterFactory.create())
			.build();

		CNJDBApi api = retrofit.create(CNJDBApi.class);
		Call<Joke> call = api.getRandomJoke();
		Response<Joke> resp = call.execute();

		if(call.isExecuted()) {
			Joke j = resp.body();
			System.out.println(j);
		}
	}

}
