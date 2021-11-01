package com.adgvit.externals.NetworkModels;

import java.util.List;

public class HomeModelNetwork{
    public Highlight highlight;
    public List<EventModelNetwork> events;
    public List<ProjectModelNetwork> projects;

    public HomeModelNetwork(Highlight highlight, List<EventModelNetwork> events, List<ProjectModelNetwork> projects) {
        this.highlight = highlight;
        this.events = events;
        this.projects = projects;
    }

    public Highlight getHighlight() {
        return highlight;
    }

    public void setHighlight(Highlight highlight) {
        this.highlight = highlight;
    }

    public List<EventModelNetwork> getEvents() {
        return events;
    }

    public void setEvents(List<EventModelNetwork> events) {
        this.events = events;
    }

    public List<ProjectModelNetwork> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectModelNetwork> projects) {
        this.projects = projects;
    }
}
