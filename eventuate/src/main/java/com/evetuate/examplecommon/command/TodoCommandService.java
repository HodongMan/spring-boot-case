package com.evetuate.examplecommon.command;

import static java.util.Arrays.asList;

import io.eventuate.tram.events.common.DomainEvent;
import io.eventuate.tram.events.publisher.DomainEventPublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evetuate.examplecommon.common.TodoCreated;
import com.evetuate.examplecommon.common.TodoDeleted;
import com.evetuate.examplecommon.common.TodoUpdated;


@Service
@Transactional
public class TodoCommandService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private DomainEventPublisher domainEventPublisher;

    public Todo create(CreateTodoRequest createTodoRequest) {
        Todo todo = new Todo(createTodoRequest.getTitle(), createTodoRequest.isCompleted(), createTodoRequest.getOrder());

        todo = todoRepository.save(todo);

        publishTodoEvent(todo, new TodoCreated(todo.getTitle(), todo.isCompleted(), todo.getExecutionOrder()));

        return todo;
    }

    private void publishTodoEvent(Todo todo, DomainEvent... domainEvents) {
        domainEventPublisher.publish(Todo.class, todo.getId(), asList(domainEvents));
    }

    private void publishTodoEvent(Long id, DomainEvent... domainEvents) {
        domainEventPublisher.publish(Todo.class, id, asList(domainEvents));
    }

    public void update(Long id, UpdateTodoRequest updateTodoRequest) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new TodoNotFoundException(id));

        todo.setTitle(updateTodoRequest.getTitle());
        todo.setCompleted(updateTodoRequest.isCompleted());
        todo.setExecutionOrder(updateTodoRequest.getOrder());

        todoRepository.save(todo);

        publishTodoEvent(todo, new TodoUpdated(todo.getTitle(), todo.isCompleted(), todo.getExecutionOrder()));
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);

        publishTodoEvent(id, new TodoDeleted());
    }
}