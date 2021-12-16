package br.com.mentorama.webfluxtest.services;

import br.com.mentorama.webfluxtest.controllers.vos.NewPointEntryVO;
import br.com.mentorama.webfluxtest.model.EntryType;
import br.com.mentorama.webfluxtest.model.PointEntry;
import br.com.mentorama.webfluxtest.model.User;
import br.com.mentorama.webfluxtest.repositories.PointEntryRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class PointEntryService {

    private final PointEntryRepository pointEntryRepository;
    private final UserService userService;


    public PointEntryService(PointEntryRepository pointEntryRepository, UserService userService){
        this.pointEntryRepository = pointEntryRepository;
        this.userService = userService;
    }

    public Mono<PointEntry> newEntry(final NewPointEntryVO newPointEntryVO){
        return this.userService.findById(newPointEntryVO.getUserId())
                .doOnNext(user -> {
                    updateBalance(user, newPointEntryVO);
                    this.userService.save(user).subscribe();
                })
                .flatMap(user -> pointEntryRepository.save(mapToPointEntry(user, newPointEntryVO)));
    }


    public Flux<PointEntry> findByUser(final String userId){
        return this.pointEntryRepository.findByUserId(userId);
    }


    public PointEntry mapToPointEntry(User user, NewPointEntryVO newPointEntryVO){
        PointEntry pointEntry = new PointEntry();
        pointEntry.setUser(user);
        pointEntry.setType(newPointEntryVO.getType());
        pointEntry.setValue(new NewPointEntryVO().getValue());
        pointEntry.setEntryDate(LocalDateTime.now());
        return pointEntry;
    }

    private void updateBalance(final User user, final NewPointEntryVO pointEntry){
        if(pointEntry.getType() == EntryType.CREDIT){
            user.setBalance(user.getBalance() + pointEntry.getValue());
        }else{
            user.setBalance(user.getBalance() - pointEntry.getValue());
        }
    }
}
