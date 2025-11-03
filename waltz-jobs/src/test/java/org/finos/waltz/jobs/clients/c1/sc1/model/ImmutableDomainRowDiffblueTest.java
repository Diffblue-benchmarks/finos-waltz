package org.finos.waltz.jobs.clients.c1.sc1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.clients.c1.sc1.model.ImmutableDomainRow.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDomainRowDiffblueTest {
  /**
   * Test {@link ImmutableDomainRow#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableDomainRow#builder()}
   *   <li>{@link ImmutableDomainRow#crossReference(String)}
   *   <li>{@link ImmutableDomainRow#parentDomainObjectId(String)}
   *   <li>{@link ImmutableDomainRow#parentExtId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableDomainRow Builder.build()", "Builder Builder.crossReference(String)",
      "Builder Builder.parentDomainObjectId(String)", "Builder Builder.parentExtId(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualParentDomainObjectIdResult = ImmutableDomainRow.builder()
        .crossReference("Cross Reference")
        .parentDomainObjectId("42");

    // Assert
    assertSame(actualParentDomainObjectIdResult, actualParentDomainObjectIdResult.parentExtId("42"));
  }

  /**
   * Test Builder {@link Builder#domainName(String)}.
   * <p>
   * Method under test: {@link Builder#domainName(String)}
   */
  @Test
  @DisplayName("Test Builder domainName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.domainName(String)"})
  void testBuilderDomainName() {
    // Arrange
    Builder builderResult = ImmutableDomainRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.domainName("Domain Name"));
  }

  /**
   * Test Builder {@link Builder#domainObjectId(String)}.
   * <p>
   * Method under test: {@link Builder#domainObjectId(String)}
   */
  @Test
  @DisplayName("Test Builder domainObjectId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.domainObjectId(String)"})
  void testBuilderDomainObjectId() {
    // Arrange
    Builder builderResult = ImmutableDomainRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.domainObjectId("42"));
  }

  /**
   * Test Builder {@link Builder#from(DomainRow)}.
   * <ul>
   *   <li>Given {@code Cross Reference}.</li>
   *   <li>Then builder build parentDomainObjectId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DomainRow)}
   */
  @Test
  @DisplayName("Test Builder from(DomainRow); given 'Cross Reference'; then builder build parentDomainObjectId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DomainRow)"})
  void testBuilderFrom_givenCrossReference_thenBuilderBuildParentDomainObjectIdIs42() {
    // Arrange
    Builder builderResult = ImmutableDomainRow.builder();
    DomainRow instance = mock(DomainRow.class);
    when(instance.crossReference()).thenReturn("Cross Reference");
    when(instance.parentDomainObjectId()).thenReturn("42");
    when(instance.parentExtId()).thenReturn("42");
    when(instance.domainName()).thenReturn("Domain Name");
    when(instance.domainObjectId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(DomainRow)}.
   * <ul>
   *   <li>Then builder build crossReference is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DomainRow)}
   */
  @Test
  @DisplayName("Test Builder from(DomainRow); then builder build crossReference is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DomainRow)"})
  void testBuilderFrom_thenBuilderBuildCrossReferenceIsNull() {
    // Arrange
    Builder builderResult = ImmutableDomainRow.builder();
    DomainRow instance = mock(DomainRow.class);
    when(instance.crossReference()).thenReturn(null);
    when(instance.parentDomainObjectId()).thenReturn("42");
    when(instance.parentExtId()).thenReturn("42");
    when(instance.domainName()).thenReturn("Domain Name");
    when(instance.domainObjectId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(DomainRow)}.
   * <ul>
   *   <li>Then builder build parentDomainObjectId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DomainRow)}
   */
  @Test
  @DisplayName("Test Builder from(DomainRow); then builder build parentDomainObjectId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DomainRow)"})
  void testBuilderFrom_thenBuilderBuildParentDomainObjectIdIsNull() {
    // Arrange
    Builder builderResult = ImmutableDomainRow.builder();
    DomainRow instance = mock(DomainRow.class);
    when(instance.crossReference()).thenReturn("Cross Reference");
    when(instance.parentDomainObjectId()).thenReturn(null);
    when(instance.parentExtId()).thenReturn("42");
    when(instance.domainName()).thenReturn("Domain Name");
    when(instance.domainObjectId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(DomainRow)}.
   * <ul>
   *   <li>Then builder build parentExtId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DomainRow)}
   */
  @Test
  @DisplayName("Test Builder from(DomainRow); then builder build parentExtId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DomainRow)"})
  void testBuilderFrom_thenBuilderBuildParentExtIdIsNull() {
    // Arrange
    Builder builderResult = ImmutableDomainRow.builder();
    DomainRow instance = mock(DomainRow.class);
    when(instance.crossReference()).thenReturn("Cross Reference");
    when(instance.parentDomainObjectId()).thenReturn("42");
    when(instance.parentExtId()).thenReturn(null);
    when(instance.domainName()).thenReturn("Domain Name");
    when(instance.domainObjectId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(DomainRow)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DomainRow)}
   */
  @Test
  @DisplayName("Test Builder from(DomainRow); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DomainRow)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableDomainRow.builder();
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
}
