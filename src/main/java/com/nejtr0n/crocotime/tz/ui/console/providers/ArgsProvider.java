package com.nejtr0n.crocotime.tz.ui.console.providers;

import com.nejtr0n.crocotime.tz.ui.console.App;
import com.nejtr0n.crocotime.tz.ui.console.Args;
import com.nejtr0n.crocotime.tz.ui.console.ConsoleProvider;
import com.nejtr0n.crocotime.tz.ui.console.exception.ValidationException;
import java.io.File;

public class ArgsProvider extends ConsoleProvider<Args, ValidationException> {

    private Args args;

    public ArgsProvider(Args args) {
        this.args = args;
    }

    public Args getValidated() throws ValidationException {
        if(this.args.size() <= 0) {
            throw new ValidationException(
                "Usage: java -jar tz.jar path_to_json_file.json" + App.EOL + App.EOL +
                "Where path_to_json_file.json - valid json with tracks"
            );
        }
        // Validate json file existence
        File file = new File(this.args.get(0));
        if(!file.exists() || file.isDirectory()) {
            throw new ValidationException(
                "File " + this.args.get(0) + " does not exists or is a directory"
            );
        }
        return this.args;
    }
}
