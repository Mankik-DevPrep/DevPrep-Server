package com.example.devprep.resume;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QResume is a Querydsl query type for Resume
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QResume extends EntityPathBase<Resume> {

    private static final long serialVersionUID = -412625199L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QResume resume = new QResume("resume");

    public final BooleanPath career = createBoolean("career");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<ResumeEnum.Job> job = createEnum("job", ResumeEnum.Job.class);

    public final com.example.devprep.user.QMember member;

    public final StringPath note = createString("note");

    public final StringPath project = createString("project");

    public final EnumPath<ResumeEnum.Stack> stack = createEnum("stack", ResumeEnum.Stack.class);

    public QResume(String variable) {
        this(Resume.class, forVariable(variable), INITS);
    }

    public QResume(Path<? extends Resume> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QResume(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QResume(PathMetadata metadata, PathInits inits) {
        this(Resume.class, metadata, inits);
    }

    public QResume(Class<? extends Resume> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.example.devprep.user.QMember(forProperty("member")) : null;
    }

}

