package com.natanielmendes.labs;

import com.natanielmendes.labs.domain.*;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nataniel.neto on 13/04/2016.
 */
public class UserInfoCriteriaBuilder {
    private List<Predicate> predicados;
    private CriteriaBuilder cb;
    private CriteriaQuery<?> cq;
    private Root<UserEntity> userEntityRoot;
    private Long entityId;
    private String name;
    private String login;
    private String email;
    private String document;
    private Boolean exactSearch;
    private Boolean caseSentitive;

    public UserInfoCriteriaBuilder(CriteriaBuilder cb, CriteriaQuery<?> cq, Root<UserEntity> userEntityRoot, Long entityId, String name, String login, String email, String document, Boolean exactSearch, Boolean caseSensitive) {
        this.cb = cb;
        this.cq = cq;
        this.userEntityRoot = userEntityRoot;
        this.entityId = entityId;
        this.name = name;
        this.login = login;
        this.email = email;
        this.document = document;
        this.exactSearch = exactSearch;
        this.caseSentitive = caseSensitive;
    }

    public Predicate[] getPredicates() {
        predicados = new ArrayList<Predicate>();

        if (entityId != null) {
            createCriteriaSearchByUserId();
        } else if (name != null) {
            createCriteriaSearchByName();
        } else if (login != null) {
            createCriteriaSearchByLogin();
        } else if (email != null) {
            createCriteriaSearchByEmail();
        } else if (document != null) {
            createCriteriaSearchByDocument();
        }

        return predicados.toArray(new Predicate[] {});
    }

    private void createCriteriaSearchByUserId() {
        predicados.add(cb.equal(userEntityRoot.get(UserEntity_.id), entityId));
    }

    private void createCriteriaSearchByName() {
        if (caseSentitive) {
            if (exactSearch) {
                predicados.add(cb.equal(userEntityRoot.get(UserEntity_.name), name));
            } else {
                predicados.add(cb.like(userEntityRoot.get(UserEntity_.name), "%" + name + "%"));
            }
        } else {
            if (exactSearch) {
                predicados.add(cb.equal(cb.upper(userEntityRoot.get(UserEntity_.name)), name.toUpperCase()));
            } else {
                predicados.add(cb.like(cb.upper(userEntityRoot.get(UserEntity_.name)), "%" + name.toUpperCase() + "%"));
            }
        }
    }

    private void createCriteriaSearchByLogin() {
        Join<UserEntity,Login> loginJoin = userEntityRoot.join(UserEntity_.login);
        if (caseSentitive) {
            if (exactSearch) {
                predicados.add(cb.equal(loginJoin.get(Login_.loginName), login));
            } else {
                predicados.add(cb.like(loginJoin.get(Login_.loginName), "%" + login + "%"));
            }
        } else {
            if (exactSearch) {
                predicados.add(cb.equal(cb.upper(loginJoin.get(Login_.loginName)), login.toUpperCase()));
            } else {
                predicados.add(cb.like(cb.upper(loginJoin.get(Login_.loginName)), "%" + login.toUpperCase() + "%"));
            }
        }
        predicados.add(cb.equal(userEntityRoot.get(UserEntity_.id), loginJoin.get(Login_.entityId)));
    }

    private void createCriteriaSearchByEmail() {
        Join<UserEntity,Email> emailJoin = userEntityRoot.join(UserEntity_.emails);
        if (caseSentitive) {
            if (exactSearch) {
                predicados.add(cb.equal(emailJoin.get(Email_.email), email));
            } else {
                predicados.add(cb.like(emailJoin.get(Email_.email), "%" + email + "%"));
            }
        } else {
            if (exactSearch) {
                predicados.add(cb.equal(cb.upper(emailJoin.get(Email_.email)), email.toUpperCase()));
            } else {
                predicados.add(cb.like(cb.upper(emailJoin.get(Email_.email)), "%" + email.toUpperCase() + "%"));
            }
        }
        predicados.add(cb.equal(userEntityRoot.get(UserEntity_.id), emailJoin.get(Email_.entityId)));
    }

    private void createCriteriaSearchByDocument() {
        Join<UserEntity,Document> documentJoin = userEntityRoot.join(UserEntity_.documents);
        if (caseSentitive) {
            if (exactSearch) {
                predicados.add(cb.equal(documentJoin.get(Document_.documentNumber), document));
            } else {
                predicados.add(cb.like(documentJoin.get(Document_.documentNumber), "%" + document + "%"));
            }
        } else {
            if (exactSearch) {
                predicados.add(cb.equal(cb.upper(documentJoin.get(Document_.documentNumber)), document.toUpperCase()));
            } else {
                predicados.add(cb.like(cb.upper(documentJoin.get(Document_.documentNumber)), "%" + document.toUpperCase() + "%"));
            }
        }
        predicados.add(cb.equal(userEntityRoot.get(UserEntity_.id), documentJoin.get(Document_.entityId)));
    }

}
