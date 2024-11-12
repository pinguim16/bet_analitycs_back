package com.bets.betsApi.predicate;

import com.bets.betsApi.beans.Bet;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.*;
import java.time.LocalDateTime;

public class BetSpecification {

    public static Specification<Bet> filter(
            Long id,
            LocalDateTime date,
            Long competitionId,
            Long categoryId,
            Long bookmakerId,
            String bookmakerBetId,
            String state,
            Long betTypeId,
            String label,
            Double odds,
            Double stake,
            Long tipsterId,
            Long sportId,
            Double profit,
            Double totalValue,
            Double closing,
            Double commission,
            Boolean live,
            Boolean freebet,
            Boolean cashout,
            Boolean eachWay,
            String comment
    ) {
        return (Root<Bet> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            Predicate predicate = cb.conjunction();

            if (id != null) {
                predicate = cb.and(predicate, cb.equal(root.get("id"), id));
            }
            if (date != null) {
                predicate = cb.and(predicate, cb.equal(root.get("date"), date));
            }
            if (competitionId != null) {
                predicate = cb.and(predicate, cb.equal(root.get("competition").get("id"), competitionId));
            }
            if (categoryId != null) {
                predicate = cb.and(predicate, cb.equal(root.get("category").get("id"), categoryId));
            }
            if (bookmakerId != null) {
                predicate = cb.and(predicate, cb.equal(root.get("bookmaker").get("id"), bookmakerId));
            }
            if (bookmakerBetId != null) {
                predicate = cb.and(predicate, cb.equal(root.get("bookmakerBetId"), bookmakerBetId));
            }
            if (state != null) {
                predicate = cb.and(predicate, cb.equal(root.get("state"), state));
            }
            if (betTypeId != null) {
                predicate = cb.and(predicate, cb.equal(root.get("betType").get("id"), betTypeId));
            }
            if (label != null) {
                predicate = cb.and(predicate, cb.like(cb.lower(root.get("label")), "%" + label.toLowerCase() + "%"));
            }
            if (odds != null) {
                predicate = cb.and(predicate, cb.equal(root.get("odds"), odds));
            }
            if (stake != null) {
                predicate = cb.and(predicate, cb.equal(root.get("stake"), stake));
            }
            if (tipsterId != null) {
                predicate = cb.and(predicate, cb.equal(root.get("tipster").get("id"), tipsterId));
            }
            if (sportId != null) {
                predicate = cb.and(predicate, cb.equal(root.get("sport").get("id"), sportId));
            }
            if (profit != null) {
                predicate = cb.and(predicate, cb.equal(root.get("profit"), profit));
            }
            if (totalValue != null) {
                predicate = cb.and(predicate, cb.equal(root.get("totalValue"), totalValue));
            }
            if (closing != null) {
                predicate = cb.and(predicate, cb.equal(root.get("closing"), closing));
            }
            if (commission != null) {
                predicate = cb.and(predicate, cb.equal(root.get("commission"), commission));
            }
            if (live != null) {
                predicate = cb.and(predicate, cb.equal(root.get("live"), live));
            }
            if (freebet != null) {
                predicate = cb.and(predicate, cb.equal(root.get("freebet"), freebet));
            }
            if (cashout != null) {
                predicate = cb.and(predicate, cb.equal(root.get("cashout"), cashout));
            }
            if (eachWay != null) {
                predicate = cb.and(predicate, cb.equal(root.get("eachWay"), eachWay));
            }
            if (comment != null) {
                predicate = cb.and(predicate, cb.like(cb.lower(root.get("comment")), "%" + comment.toLowerCase() + "%"));
            }

            return predicate;
        };
    }
}
