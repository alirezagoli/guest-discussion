create index IX_C0B070CD on GDP_Comment (parentId, titleId, verified);
create index IX_73EC900A on GDP_Comment (titleId);
create index IX_16F13346 on GDP_Comment (titleId, verified);

create index IX_52ADC273 on GDP_PortletTitle (titleId);

create index IX_13096E16 on GDP_Title (companyId);