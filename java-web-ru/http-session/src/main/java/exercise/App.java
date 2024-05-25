package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    private static List<Map<String, String>> getPageData(int page, int per) {
        // Gets page of data from USERS

        List<Map<String, String>> ret = new ArrayList<>();
        int totalLength = USERS.size();
        int maxStartIndex = totalLength - 1; // Show only one last item on crazy input

        int startIndex = (page - 1) * per;
        if (startIndex > maxStartIndex) {
            startIndex = maxStartIndex;
        }

        int lastIndex = startIndex + per - 1;
        if (lastIndex > maxStartIndex) {
            lastIndex = maxStartIndex;
        }

        for (int i = startIndex; i <= lastIndex; i++) {
            ret.add(USERS.get(i));
        }

        return ret;
    }

    public static Javalin getApp() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        // BEGIN
        app.get("/users", ctx -> {
            int page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
            int per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);
            ctx.json(getPageData(page, per));
        });
        // END
        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
