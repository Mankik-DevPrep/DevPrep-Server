package com.example.devprep.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1786970287L;

    public static final QUser user = new QUser("user");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath image = createString("image");

    public final EnumPath<MemberEnum.Level> level = createEnum("level", MemberEnum.Level.class);

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public QUser(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QUser(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

