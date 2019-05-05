package com.hrnchshn.finance.subuz.service;

import com.hrnchshn.finance.auser.AUser;
import com.hrnchshn.finance.auser.AUserRepository;
import com.hrnchshn.finance.exeptions.EntityNotFoundException;
import com.hrnchshn.finance.subuz.dao.JourneySubscriptionDao;
import com.hrnchshn.finance.subuz.entity.JourneySubscription;
import com.hrnchshn.finance.subuz.entity.JourneySubscriptionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ivan.hrynchyshyn
 */
@Service
@RequiredArgsConstructor
public class JourneySubscriptionService {
    private final JourneySubscriptionDao journeySubscriptionDao;
    private final AUserRepository userRepository;

    public JourneySubscriptionDto save(JourneySubscriptionDto subscriptionDto){
        JourneySubscription journeySubscription = subscriptionDto.toEntity();
        journeySubscription.setUser(getAuthUser());
        return journeySubscriptionDao.saveAndFlush(journeySubscription).toDto();
    }

    public JourneySubscriptionDto update(Long id, JourneySubscriptionDto subscription){
        JourneySubscription foundSubscription = journeySubscriptionDao.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("cant_find_given_subscription"));

        foundSubscription.setDate(subscription.getDate());
        foundSubscription.setSrcPlace(subscription.getFrom());
        foundSubscription.setDestPlace(subscription.getTo());
        foundSubscription.setWarningMessage(subscription.getWarningMessage());
        return journeySubscriptionDao.save(foundSubscription).toDto();
    }

    public void deleteSubscription(Long id){
        journeySubscriptionDao.deleteById(id);
    }

    public JourneySubscriptionDto getOne(Long id){
        return journeySubscriptionDao.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("cant_find_given_subscription"))
                .toDto();
    }

    public List<JourneySubscriptionDto> getAll(){
        return journeySubscriptionDao.findAllByUserOrderByCreated(getAuthUser())
                .stream()
                .map(JourneySubscription::toDto)
                .collect(Collectors.toList());
    }

    private AUser getAuthUser(){
        String username = String.class.cast(SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal());
        return userRepository.findByUsername(username);
    }
}
