package com.example.devprep.resume;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QResume is a Querydsl query type for Resume
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QResume extends EntityPathBase<Resume> {

    private static final long serialVersionUID = -412625199L;

    public static final QResume resume = new QResume("resume");

    public final StringPath career = createString("career");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<ResumeEnum.Job> job = createEnum("job", ResumeEnum.Job.class);

    public final StringPath note = createString("note");

    public final StringPath project = createString("project");

    public final EnumPath<ResumeEnum.Stack> stack = createEnum("stack", ResumeEnum.Stack.class);

    public QResume(String variable) {
        super(Resume.class, forVariable(variable));
    }

    public QResume(Path<? extends Resume> path) {
        super(path.getType(), path.getMetadata());
    }

    public QResume(PathMetadata metadata) {
        super(Resume.class, metadata);
    }

}

