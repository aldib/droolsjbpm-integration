package org.kie.services.client.serialization.jaxb.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.jbpm.services.task.impl.model.xml.JaxbTask;
import org.kie.api.command.Command;
import org.kie.api.task.model.Task;

@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
public class JaxbTaskResponse extends JaxbTask implements Task, JaxbCommandResponse<Task> {

    @XmlAttribute
    @XmlSchemaType(name = "int")
    private Integer index;

    @XmlElement(name = "command-name")
    @XmlSchemaType(name = "string")
    private String commandName;

    public JaxbTaskResponse() {
        // Default constructor
    }

    public JaxbTaskResponse(int i, Command<?> cmd) {
        this.index = i;
        this.commandName = cmd.getClass().getSimpleName();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.kie.services.client.serialization.jaxb.impl.JaxbCommandResponse#getIndex()
     */
    @Override
    public Integer getIndex() {
        return index;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.kie.services.client.serialization.jaxb.impl.JaxbCommandResponse#getCommandName()
     */
    @Override
    public String getCommandName() {
        return commandName;
    }

    public JaxbTaskResponse(Task task, int i, Command<?> cmd) {
        super(task);
        this.index = i;
        this.commandName = cmd.getClass().getSimpleName();
    }

    public Task getResult() {
        return this;
   }

    @Override
    public void setIndex(Integer index) {
        this.index = index;
        
    }

    @Override
    public void setCommandName(String cmdName) {
        this.commandName = cmdName;
    }

    @Override
    public void setResult(Task result) {
        initialize(result);
    }

}