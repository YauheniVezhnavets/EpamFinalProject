package com.epam.web.command;

public class CommandResult {

    private final String page;
    private final boolean isRedirected;


    private CommandResult(String page, boolean isRedirected) {
        this.page = page;
        this.isRedirected = isRedirected;
    }

    public static CommandResult forward(String page) {
        return new CommandResult(page, false);
    }

    public static CommandResult redirect(String page) {
        return new CommandResult(page, true);
    }

    public String getPage() {
        return page;
    }

    public boolean isRedirected() {
        return isRedirected;
    }

}
