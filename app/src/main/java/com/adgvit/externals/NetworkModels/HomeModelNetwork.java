package com.adgvit.externals.NetworkModels;

import com.adgvit.externals.DataModels.HomeDomainsObject;

import java.util.ArrayList;
import java.util.List;

public class HomeModelNetwork{
    public Highlight highlight;
    public List<EventModelNetwork> events;
    public List<ProjectModelNetwork> projects;
    public List<HomeDomainsObject> domains;

    public HomeModelNetwork(Highlight highlight, List<EventModelNetwork> events, List<ProjectModelNetwork> projects, List<HomeDomainsObject> domains) {
        this.highlight = highlight;
        this.events = events;
        this.projects = projects;
        this.domains = domains;
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

    public List<HomeDomainsObject> getDomains() {
        return domains;
    }

    public void setDomains(List<HomeDomainsObject> domains) {
        this.domains = domains;
    }
}
