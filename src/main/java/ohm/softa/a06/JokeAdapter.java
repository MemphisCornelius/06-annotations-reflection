package ohm.softa.a06;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import ohm.softa.a06.model.Joke;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JokeAdapter extends TypeAdapter<Joke[]> {
	@Override
	public void write(JsonWriter out, Joke[] value) throws IOException {
		/*out.beginObject();
		out.name("id").value(value.getIdentifier());
		out.name("value").value(value.getContent());
		out.name("categories").beginArray();
		for (String category : value.getRubrics()) {
			out.value(category);
		}
		out.endArray();*/
	}

	@Override
	public Joke[] read(JsonReader in) throws IOException {

		final Joke j = new Joke();

		while (in.hasNext()) {
			switch (in.nextName()) {
				case "id":
					j.setIdentifier(in.nextString());
					break;
				case "value":
					j.setContent(in.nextString());
					break;
				case "categories":
					List<String> list = new ArrayList<>();
					in.beginArray();
					while (in.hasNext()) {
						list.add(in.nextString());
					}
					j.setRubrics((String[]) list.toArray());
					in.endArray();
					break;
			}
		}

		return j;
	}
}
