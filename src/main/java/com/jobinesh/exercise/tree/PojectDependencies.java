package com.jobinesh.exercise.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * You are given a list of projects and a list of dependencies
 * (which is a list of pairs of projects, where the 1st project is
 * dependent on the 2nd project. All of a project's dependencies
 * must be built before the project is. Find a build order that will allow
 * the projects to be built.
 * If there is no valid build order, return an error
 * Example :
 * INPUT
 * projects : a, b, c, d, e, f
 * dependencies : (d,a), (b,f), (d,b), (a,f), (c,d)
 * OUTPUT : f, e, a b, d, c
 */
public class PojectDependencies {

    static enum State {
        NOT_VISITED,
        VISITED,
        VISITING
    }

    static class Project {
        private String name;
        List<Project> children = new ArrayList<>();
        Map<String,Project> neighbours = new HashMap<>();
        private State state = State.NOT_VISITED;

        public Project(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        List<Project> getChildren() {
            return children;
        }

        void addChildren(Project child) {
            if(!neighbours.containsKey(child.getName()) ){
                children.add(child);
                neighbours.put(child.getName(), child);
            }
        }

        public State getState() {
            return state;
        }

        public void setState(State state) {
            this.state = state;
        }
    }

    static class Graph {
        Map<String, Project> projectMap = new HashMap<>();

        List<Project> projects = new ArrayList<>();
        int index = 0;

        public Graph(String[] projects, String[][] edges) {

            for (String prj : projects) {
                addProject(prj);
            }
            for (String[] edge : edges) {
                addEdge(edge[0], edge[1]);
            }
        }

        void addProject(Project proj) {
            projectMap.put(proj.getName(), proj);
        }

        void addProject(String projName) {
            if (projectMap.get(projName) == null) {
                Project proj = new Project(projName);
                projectMap.put(projName, proj);
                projects.add(proj);
            }
        }

        void addEdge(String prjname1, String prjname2) {
            Project proj1 = projectMap.get(prjname1);
            proj1.addChildren(projectMap.get(prjname2));
        }


        public Stack<String> getOrderedProjects() {
            Stack<String> projSack = new Stack<>();
            Iterator<Project> iterator = projects.iterator();
            while (iterator.hasNext()) {
                Project proj = iterator.next();
                if (proj.getState() == State.NOT_VISITED) {
                    if (!doDfs(proj, projSack)) {
                        return null;
                    }
                }
            }
            return projSack;
        }


        public boolean doDfs(Project project, Stack<String> projectOrder) {
            if (project.getState() == State.VISITING) {
                return false;
            }
            if (project.getState() == State.NOT_VISITED) {
                project.setState(State.VISITING);
                List<Project> children = project.getChildren();
                for (Project proj : children) {
                    if (!doDfs(proj, projectOrder)) {
                        return false;
                    }
                }
                project.setState(State.VISITED);
                projectOrder.push(project.getName());
            }
            return true;
        }
    }

    public static void main(String[] args) {
        /*
         * projects : a, b, c, d, e, f
         * dependencies : (d,a), (b,f), (d,b), (a,f), (c,d)
         * OUTPUT : f, e, a b, d, c
         */
        String[] projects = {"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = {{"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}};
                //{{"d", "a"}, {"b", "f"}, {"d", "b"}, {"a", "f"}, {"c", "d"}};
        Stack<String> result = new PojectDependencies.Graph(projects, dependencies).getOrderedProjects();
        result.forEach(System.out::println);
    }
}
