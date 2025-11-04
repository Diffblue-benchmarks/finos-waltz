package org.finos.waltz.jobs.clients.c1.sc1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableDomainRowDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableDomainRow#builder()}
   *   <li>{@link ImmutableDomainRow#crossReference(String)}
   *   <li>{@link ImmutableDomainRow#parentDomainObjectId(String)}
   *   <li>{@link ImmutableDomainRow#parentExtId(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableDomainRow.Builder actualParentDomainObjectIdResult = ImmutableDomainRow.builder()
        .crossReference("Cross Reference")
        .parentDomainObjectId("42");

    // Assert
    assertSame(actualParentDomainObjectIdResult, actualParentDomainObjectIdResult.parentExtId("42"));
  }

  /**
   * Method under test: {@link ImmutableDomainRow.Builder#domainName(String)}
   */
  @Test
  void testBuilderDomainName() {
    // Arrange
    ImmutableDomainRow.Builder builderResult = ImmutableDomainRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.domainName("Domain Name"));
  }

  /**
   * Method under test: {@link ImmutableDomainRow.Builder#domainObjectId(String)}
   */
  @Test
  void testBuilderDomainObjectId() {
    // Arrange
    ImmutableDomainRow.Builder builderResult = ImmutableDomainRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.domainObjectId("42"));
  }

  /**
   * Method under test: {@link ImmutableDomainRow.Builder#from(DomainRow)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableDomainRow.Builder builderResult = ImmutableDomainRow.builder();
    DomainRow instance = mock(DomainRow.class);
    when(instance.crossReference()).thenReturn("Cross Reference");
    when(instance.parentDomainObjectId()).thenReturn("42");
    when(instance.parentExtId()).thenReturn("42");
    when(instance.domainName()).thenReturn("Domain Name");
    when(instance.domainObjectId()).thenReturn("42");

    // Act
    ImmutableDomainRow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).crossReference();
    verify(instance).domainName();
    verify(instance).domainObjectId();
    verify(instance).parentDomainObjectId();
    verify(instance).parentExtId();
    ImmutableDomainRow buildResult = builderResult.build();
    assertEquals("42", buildResult.domainObjectId());
    assertEquals("42", buildResult.parentDomainObjectId());
    assertEquals("42", buildResult.parentExtId());
    assertEquals("Cross Reference", buildResult.crossReference());
    assertEquals("Domain Name", buildResult.domainName());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableDomainRow.Builder#from(DomainRow)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableDomainRow.Builder builderResult = ImmutableDomainRow.builder();
    DomainRow instance = mock(DomainRow.class);
    when(instance.parentDomainObjectId()).thenThrow(new IllegalStateException("instance"));
    when(instance.domainName()).thenReturn("Domain Name");
    when(instance.domainObjectId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).domainName();
    verify(instance).domainObjectId();
    verify(instance).parentDomainObjectId();
  }

  /**
   * Method under test: {@link ImmutableDomainRow.Builder#from(DomainRow)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableDomainRow.Builder builderResult = ImmutableDomainRow.builder();
    DomainRow instance = mock(DomainRow.class);
    when(instance.crossReference()).thenReturn(null);
    when(instance.parentDomainObjectId()).thenReturn("42");
    when(instance.parentExtId()).thenReturn("42");
    when(instance.domainName()).thenReturn("Domain Name");
    when(instance.domainObjectId()).thenReturn("42");

    // Act
    ImmutableDomainRow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).crossReference();
    verify(instance).domainName();
    verify(instance).domainObjectId();
    verify(instance).parentDomainObjectId();
    verify(instance).parentExtId();
    ImmutableDomainRow buildResult = builderResult.build();
    assertEquals("42", buildResult.domainObjectId());
    assertEquals("42", buildResult.parentDomainObjectId());
    assertEquals("42", buildResult.parentExtId());
    assertEquals("Domain Name", buildResult.domainName());
    assertNull(buildResult.crossReference());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableDomainRow.Builder#from(DomainRow)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableDomainRow.Builder builderResult = ImmutableDomainRow.builder();
    DomainRow instance = mock(DomainRow.class);
    when(instance.crossReference()).thenReturn("Cross Reference");
    when(instance.parentDomainObjectId()).thenReturn(null);
    when(instance.parentExtId()).thenReturn("42");
    when(instance.domainName()).thenReturn("Domain Name");
    when(instance.domainObjectId()).thenReturn("42");

    // Act
    ImmutableDomainRow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).crossReference();
    verify(instance).domainName();
    verify(instance).domainObjectId();
    verify(instance).parentDomainObjectId();
    verify(instance).parentExtId();
    ImmutableDomainRow buildResult = builderResult.build();
    assertEquals("42", buildResult.domainObjectId());
    assertEquals("42", buildResult.parentExtId());
    assertEquals("Cross Reference", buildResult.crossReference());
    assertEquals("Domain Name", buildResult.domainName());
    assertNull(buildResult.parentDomainObjectId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableDomainRow.Builder#from(DomainRow)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableDomainRow.Builder builderResult = ImmutableDomainRow.builder();
    DomainRow instance = mock(DomainRow.class);
    when(instance.crossReference()).thenReturn("Cross Reference");
    when(instance.parentDomainObjectId()).thenReturn("42");
    when(instance.parentExtId()).thenReturn(null);
    when(instance.domainName()).thenReturn("Domain Name");
    when(instance.domainObjectId()).thenReturn("42");

    // Act
    ImmutableDomainRow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).crossReference();
    verify(instance).domainName();
    verify(instance).domainObjectId();
    verify(instance).parentDomainObjectId();
    verify(instance).parentExtId();
    ImmutableDomainRow buildResult = builderResult.build();
    assertEquals("42", buildResult.domainObjectId());
    assertEquals("42", buildResult.parentDomainObjectId());
    assertEquals("Cross Reference", buildResult.crossReference());
    assertEquals("Domain Name", buildResult.domainName());
    assertNull(buildResult.parentExtId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableDomainRow#copyOf(DomainRow)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    DomainRow instance = mock(DomainRow.class);
    when(instance.crossReference()).thenReturn("Cross Reference");
    when(instance.parentDomainObjectId()).thenReturn("42");
    when(instance.parentExtId()).thenReturn("42");
    when(instance.domainName()).thenReturn("Domain Name");
    when(instance.domainObjectId()).thenReturn("42");

    // Act
    ImmutableDomainRow actualCopyOfResult = ImmutableDomainRow.copyOf(instance);

    // Assert
    verify(instance).crossReference();
    verify(instance).domainName();
    verify(instance).domainObjectId();
    verify(instance).parentDomainObjectId();
    verify(instance).parentExtId();
    assertEquals("42", actualCopyOfResult.domainObjectId());
    assertEquals("42", actualCopyOfResult.parentDomainObjectId());
    assertEquals("42", actualCopyOfResult.parentExtId());
    assertEquals("Cross Reference", actualCopyOfResult.crossReference());
    assertEquals("Domain Name", actualCopyOfResult.domainName());
  }
}
