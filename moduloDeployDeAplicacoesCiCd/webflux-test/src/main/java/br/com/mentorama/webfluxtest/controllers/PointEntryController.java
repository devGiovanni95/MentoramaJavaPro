package br.com.mentorama.webfluxtest.controllers;

import br.com.mentorama.webfluxtest.controllers.vos.NewPointEntryVO;
import br.com.mentorama.webfluxtest.model.PointEntry;
import br.com.mentorama.webfluxtest.services.PointEntryService;
import org.springframework.boot.jms.*;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.github.marschall.jfr.jmstemplate.JfrJmsOperations;

@RestController
@RequestMapping("/points/entry")
public class PointEntryController {

    private final PointEntryService pointEntryService;
    private final JmsTemplate jmsTemplate;
    private final JmsTemplate jmsTemplateTopio;


    public PointEntryController(PointEntryService pointEntryService, JmsTemplate jmsTemplate, JmsTemplate jmsTemplateTopio){
        this.pointEntryService = pointEntryService;
        this.jmsTemplate = jmsTemplate;
        this.jmsTemplateTopio = jmsTemplateTopio;
    }

    @GetMapping("/{userId}")
    public Flux<PointEntry> findByUser(@PathVariable("UserId") final String userId){
        return this.pointEntryService.findByUser(userId);
    }


    @PostMapping
    public Mono<PointEntry> newEntry(@RequestBody final NewPointEntryVO newPointEntryVO){
        return this.pointEntryService.newEntry(newPointEntryVO);
    }
}
