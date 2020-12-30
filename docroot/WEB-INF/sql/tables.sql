create table GDP_Comment (
	commentId LONG not null primary key IDENTITY,
	groupId LONG,
	companyId LONG,
	modifiedDate DATE null,
	parentId LONG,
	parentName VARCHAR(75) null,
	commentText TEXT null,
	guestName VARCHAR(75) null,
	guestEmailAddress VARCHAR(75) null,
	guestEmailNotification BOOLEAN,
	likeCount LONG,
	dislikeCount LONG,
	titleId LONG,
	verified BOOLEAN,
	hasAnswer BOOLEAN
);

create table GDP_PortletTitle (
	portletId VARCHAR(75) not null primary key,
	titleId LONG
);

create table GDP_Title (
	titleId LONG not null primary key IDENTITY,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	titleText VARCHAR(1000) null,
	newCommentDraft TEXT null,
	answerCommentDraft TEXT null
);