package RESTfulWebServicesOpdracht10.repository;

import RESTfulWebServicesOpdracht10.model.Message;

import java.util.List;

public interface MessageRepository {

    public Message getMessageById(int id);
    public List<Message> getAllMessages();
    public List<Message> getAllMessagesByAuthor(String author);
    public Message createMessage(Message message);
    public Message updateMessage(Message message);
    public void deleteMessage(int id);
}
