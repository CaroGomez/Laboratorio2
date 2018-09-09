/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Actor;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import session.ActorManager;

/**
 *
 * @author carol
 */
@Named(value = "actorMBean")
@SessionScoped
public class ActorMBean implements Serializable {

    @EJB
    private ActorManager actorManager;
    private Actor actor;
    private List<Actor> actors;

    public ActorMBean() {
    }
    
    public Actor getActor() {
        return actor;
    }

    public List<Actor> getActors() {
        if(actors == null || actors.isEmpty()){
            this.refresh();
        }
        return actors;
    }
    
    private void refresh(){
        actors = actorManager.getAllActor();
    }
    
    public Actor getDetails(){
        return actor;
    }
    
    public String showDetails(Actor actor){
        this.actor = actor;
        return "ActorDetails";
    }
    
    public String update(){
        System.out.println("managedbeans.ActorMBean.update() " + "###UPDATE###");
        actor = actorManager.update(actor);
        return "Actor Update";
    }
    
    public String List(){
        System.out.println("###LIST###");
        return "ActorList";
    }
    
}
