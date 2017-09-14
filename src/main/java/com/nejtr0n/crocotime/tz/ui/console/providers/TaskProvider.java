package com.nejtr0n.crocotime.tz.ui.console.providers;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.inject.Inject;
import java.lang.reflect.Type;
import com.nejtr0n.crocotime.tz.ui.console.Args;
import com.nejtr0n.crocotime.tz.ui.console.ConsoleProvider;
import com.nejtr0n.crocotime.tz.ui.console.ConsoleTask;
import com.nejtr0n.crocotime.tz.ui.console.exception.JsonFileNotFoundedException;
import com.nejtr0n.crocotime.tz.ui.console.exception.ValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskProvider extends ConsoleProvider<ConsoleTask, ValidationException> {

    private Args args;

    @Inject
    public TaskProvider(Args args) {
        this.args = args;
    }

    public ConsoleTask getValidated() throws ValidationException {
        try {
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(Date.class, new DateDeserializer());
            Gson gson = builder.setPrettyPrinting().create();
            JsonReader reader = new JsonReader(new FileReader(this.args.get(0)));
            ConsoleTask task = gson
                    .fromJson(reader, ConsoleTask.class);

            if (task == null) {
                throw new ValidationException(
                        "Incorrect json file"
                );
            }
            if (task.getHost() == null) {
                throw new ValidationException(
                        "Please provide Web Api Endpoint to json file"
                );
            }
            if (task.getServerToken() == null) {
                throw new ValidationException(
                        "Please provide Web Api server token to json file"
                );
            }
            return task;

        } catch (FileNotFoundException e) {
            throw new JsonFileNotFoundedException(
                    e.getMessage()
            );
        }
    }

    /**
     * Convert string fields to date objects
     */
    class DateDeserializer implements JsonDeserializer {
        public Date deserialize(JsonElement json, Type typeOfT,
                                JsonDeserializationContext context)
                throws JsonParseException {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            try {
                return json == null ? null : formatter.parse(json.getAsString());
            } catch (ParseException e) {
                return null;
            }
        }
    }
}
