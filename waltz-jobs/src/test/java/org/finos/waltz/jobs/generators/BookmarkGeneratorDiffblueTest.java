package org.finos.waltz.jobs.generators;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.schema.tables.records.BookmarkRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class BookmarkGeneratorDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link BookmarkGenerator}
   */
  @Test
  void testNewBookmarkGenerator() {
    // Arrange and Act
    BookmarkGenerator actualBookmarkGenerator = new BookmarkGenerator();

    // Assert
    assertArrayEquals(new String[]{"https://en.wikipedia.org/wiki/%s", "https://www.bing.com/search?q=%s",
        "https://www.google.co.uk/search?q=%s"}, actualBookmarkGenerator.urls);
    assertArrayEquals(new String[]{"All about %s", "%s Info", "%s Data", "Docs on %s", "Link to %s"},
        actualBookmarkGenerator.text);
    assertArrayEquals(
        new String[]{"APPLICATION_INSTANCE", "BUILD_SYSTEM", "BUSINESS_SPECIFICATION", "DOCUMENTATION", "ISSUE_TRACKER",
            "MONITORING", "QUALITY_CONTROL", "RETIREMENT_PLAN", "SOURCE_CODE_CONTROL", "TECHNICAL_SPECIFICATION"},
        actualBookmarkGenerator.bookmarkKinds);
  }

  /**
   * Method under test: {@link BookmarkGenerator#remove(ApplicationContext)}
   */
  @Test
  void testRemove() throws DataAccessException, BeansException {
    // Arrange
    BookmarkGenerator bookmarkGenerator = new BookmarkGenerator();
    DeleteConditionStep<BookmarkRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteUsingStep<BookmarkRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DefaultDSLContext defaultDSLContext = mock(DefaultDSLContext.class);
    when(defaultDSLContext.deleteFrom(Mockito.<Table<BookmarkRecord>>any())).thenReturn(deleteUsingStep);
    AnnotationConfigApplicationContext ctx = mock(AnnotationConfigApplicationContext.class);
    when(ctx.getBean(Mockito.<Class<DSLContext>>any())).thenReturn(defaultDSLContext);

    // Act
    boolean actualRemoveResult = bookmarkGenerator.remove(ctx);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(defaultDSLContext).deleteFrom(isA(Table.class));
    verify(ctx).getBean(isA(Class.class));
    assertFalse(actualRemoveResult);
  }
}
