package org.finos.waltz.model.change_initiative;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.OrganisationalUnitIdProvider;
import org.finos.waltz.model.ParentIdProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.change_initiative.ImmutableChangeInitiative.Builder;
import org.finos.waltz.model.change_initiative.ImmutableChangeInitiative.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableChangeInitiativeDiffblueTest {
  /**
   * Test {@link ImmutableChangeInitiative#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableChangeInitiative#builder()}
   *   <li>{@link ImmutableChangeInitiative#description(String)}
   *   <li>{@link ImmutableChangeInitiative#externalId(String)}
   *   <li>{@link ImmutableChangeInitiative#kind(EntityKind)}
   *   <li>{@link ImmutableChangeInitiative#lastUpdate(Date)}
   *   <li>{@link ImmutableChangeInitiative#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableChangeInitiative Builder.build()", "Builder Builder.description(String)",
      "Builder Builder.externalId(String)", "Builder Builder.kind(EntityKind)", "Builder Builder.lastUpdate(Date)",
      "Builder Builder.provenance(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualExternalIdResult = ImmutableChangeInitiative.builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);
    Builder actualLastUpdateResult = actualKindResult
        .lastUpdate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Optional<? extends Date> lastUpdate = Optional
        .of(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Builder actualParentIdResult = actualLastUpdateResult.lastUpdate(lastUpdate).parentId(1L);
    Optional<Long> parentId = Optional.<Long>of(1L);
    Builder actualParentIdResult2 = actualParentIdResult.parentId(parentId);

    // Assert
    assertSame(actualParentIdResult2, actualParentIdResult2.provenance("Provenance"));
  }

  /**
   * Test Builder {@link Builder#changeInitiativeKind(ChangeInitiativeKind)}.
   * <p>
   * Method under test: {@link Builder#changeInitiativeKind(ChangeInitiativeKind)}
   */
  @Test
  @DisplayName("Test Builder changeInitiativeKind(ChangeInitiativeKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.changeInitiativeKind(ChangeInitiativeKind)"})
  void testBuilderChangeInitiativeKind() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changeInitiativeKind(ChangeInitiativeKind.INITIATIVE));
  }

  /**
   * Test Builder {@link Builder#endDate(Date)}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#endDate(Date)}
   */
  @Test
  @DisplayName("Test Builder endDate(Date); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.endDate(Date)"})
  void testBuilderEndDate_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.endDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Test Builder {@link Builder#from(ChangeInitiative)} with {@code ChangeInitiative}.
   * <p>
   * Method under test: {@link Builder#from(ChangeInitiative)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeInitiative) with 'ChangeInitiative'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeInitiative)"})
  void testBuilderFromWithChangeInitiative() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    ChangeInitiative instance = mock(ChangeInitiative.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.startDate()).thenReturn(fromResult);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Date> ofResult2 = Optional
        .of(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.lastUpdate()).thenReturn(ofResult2);
    when(instance.changeInitiativeKind()).thenReturn(ChangeInitiativeKind.INITIATIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult4);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.endDate()).thenReturn(fromResult2);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).parentId();
    verify(instance).provenance();
    verify(instance).changeInitiativeKind();
    verify(instance).endDate();
    verify(instance).kind();
    verify(instance).lastUpdate();
    verify(instance).lifecyclePhase();
    verify(instance).startDate();
    ImmutableChangeInitiative buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, buildResult.changeInitiativeKind());
    assertSame(fromResult2, buildResult.endDate());
    assertSame(fromResult, buildResult.startDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeInitiative)} with {@code ChangeInitiative}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link ChangeInitiative} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeInitiative)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeInitiative) with 'ChangeInitiative'; given empty; when ChangeInitiative id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeInitiative)"})
  void testBuilderFromWithChangeInitiative_givenEmpty_whenChangeInitiativeIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    ChangeInitiative instance = mock(ChangeInitiative.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.startDate()).thenReturn(fromResult);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<Date> ofResult = Optional
        .of(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.lastUpdate()).thenReturn(ofResult);
    when(instance.changeInitiativeKind()).thenReturn(ChangeInitiativeKind.INITIATIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult3);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.endDate()).thenReturn(fromResult2);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).parentId();
    verify(instance).provenance();
    verify(instance).changeInitiativeKind();
    verify(instance).endDate();
    verify(instance).kind();
    verify(instance).lastUpdate();
    verify(instance).lifecyclePhase();
    verify(instance).startDate();
    ImmutableChangeInitiative buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, buildResult.changeInitiativeKind());
    assertSame(fromResult2, buildResult.endDate());
    assertSame(fromResult, buildResult.startDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeInitiative)} with {@code ChangeInitiative}.
   * <ul>
   *   <li>Then builder build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeInitiative)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeInitiative) with 'ChangeInitiative'; then builder build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeInitiative)"})
  void testBuilderFromWithChangeInitiative_thenBuilderBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    ChangeInitiative instance = mock(ChangeInitiative.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.startDate()).thenReturn(fromResult);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Date> ofResult2 = Optional
        .of(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.lastUpdate()).thenReturn(ofResult2);
    when(instance.changeInitiativeKind()).thenReturn(ChangeInitiativeKind.INITIATIVE);
    when(instance.description()).thenReturn(null);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult4);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.endDate()).thenReturn(fromResult2);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).parentId();
    verify(instance).provenance();
    verify(instance).changeInitiativeKind();
    verify(instance).endDate();
    verify(instance).kind();
    verify(instance).lastUpdate();
    verify(instance).lifecyclePhase();
    verify(instance).startDate();
    ImmutableChangeInitiative buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertNull(buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, buildResult.changeInitiativeKind());
    assertSame(fromResult2, buildResult.endDate());
    assertSame(fromResult, buildResult.startDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeInitiative)} with {@code ChangeInitiative}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeInitiative)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeInitiative) with 'ChangeInitiative'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeInitiative)"})
  void testBuilderFromWithChangeInitiative_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    ChangeInitiative instance = mock(ChangeInitiative.class);
    when(instance.startDate()).thenThrow(new IllegalStateException("instance"));
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Date> ofResult2 = Optional
        .of(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.lastUpdate()).thenReturn(ofResult2);
    when(instance.changeInitiativeKind()).thenReturn(ChangeInitiativeKind.INITIATIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult4);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.endDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).parentId();
    verify(instance).provenance();
    verify(instance).changeInitiativeKind();
    verify(instance).endDate();
    verify(instance).kind();
    verify(instance).lastUpdate();
    verify(instance).lifecyclePhase();
    verify(instance).startDate();
  }

  /**
   * Test Builder {@link Builder#from(ChangeInitiative)} with {@code ChangeInitiative}.
   * <ul>
   *   <li>When {@link ChangeInitiative} {@link ExternalIdProvider#externalId()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeInitiative)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeInitiative) with 'ChangeInitiative'; when ChangeInitiative externalId() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeInitiative)"})
  void testBuilderFromWithChangeInitiative_whenChangeInitiativeExternalIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    ChangeInitiative instance = mock(ChangeInitiative.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.startDate()).thenReturn(fromResult);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Date> ofResult2 = Optional
        .of(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.lastUpdate()).thenReturn(ofResult2);
    when(instance.changeInitiativeKind()).thenReturn(ChangeInitiativeKind.INITIATIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult3);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.endDate()).thenReturn(fromResult2);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).parentId();
    verify(instance).provenance();
    verify(instance).changeInitiativeKind();
    verify(instance).endDate();
    verify(instance).kind();
    verify(instance).lastUpdate();
    verify(instance).lifecyclePhase();
    verify(instance).startDate();
    ImmutableChangeInitiative buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, buildResult.changeInitiativeKind());
    assertSame(fromResult2, buildResult.endDate());
    assertSame(fromResult, buildResult.startDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeInitiative)} with {@code ChangeInitiative}.
   * <ul>
   *   <li>When {@link ChangeInitiative} {@link ChangeInitiative#lastUpdate()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeInitiative)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeInitiative) with 'ChangeInitiative'; when ChangeInitiative lastUpdate() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeInitiative)"})
  void testBuilderFromWithChangeInitiative_whenChangeInitiativeLastUpdateReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    ChangeInitiative instance = mock(ChangeInitiative.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.startDate()).thenReturn(fromResult);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Date> emptyResult = Optional.empty();
    when(instance.lastUpdate()).thenReturn(emptyResult);
    when(instance.changeInitiativeKind()).thenReturn(ChangeInitiativeKind.INITIATIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult3);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.endDate()).thenReturn(fromResult2);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).parentId();
    verify(instance).provenance();
    verify(instance).changeInitiativeKind();
    verify(instance).endDate();
    verify(instance).kind();
    verify(instance).lastUpdate();
    verify(instance).lifecyclePhase();
    verify(instance).startDate();
    ImmutableChangeInitiative buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, buildResult.changeInitiativeKind());
    assertSame(fromResult2, buildResult.endDate());
    assertSame(fromResult, buildResult.startDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeInitiative)} with {@code ChangeInitiative}.
   * <ul>
   *   <li>When {@link ChangeInitiative} {@link ParentIdProvider#parentId()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ChangeInitiative)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeInitiative) with 'ChangeInitiative'; when ChangeInitiative parentId() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ChangeInitiative)"})
  void testBuilderFromWithChangeInitiative_whenChangeInitiativeParentIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    ChangeInitiative instance = mock(ChangeInitiative.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.startDate()).thenReturn(fromResult);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Date> ofResult2 = Optional
        .of(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.lastUpdate()).thenReturn(ofResult2);
    when(instance.changeInitiativeKind()).thenReturn(ChangeInitiativeKind.INITIATIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentId()).thenReturn(emptyResult);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.endDate()).thenReturn(fromResult2);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).parentId();
    verify(instance).provenance();
    verify(instance).changeInitiativeKind();
    verify(instance).endDate();
    verify(instance).kind();
    verify(instance).lastUpdate();
    verify(instance).lifecyclePhase();
    verify(instance).startDate();
    ImmutableChangeInitiative buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, buildResult.changeInitiativeKind());
    assertSame(fromResult2, buildResult.endDate());
    assertSame(fromResult, buildResult.startDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   * <ul>
   *   <li>Given {@code ALL}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'; given 'ALL'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_givenAll_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given Optional with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenOptionalWithFoo() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(OrganisationalUnitIdProvider)} with {@code OrganisationalUnitIdProvider}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(OrganisationalUnitIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(OrganisationalUnitIdProvider) with 'OrganisationalUnitIdProvider'; given one; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(OrganisationalUnitIdProvider)"})
  void testBuilderFromWithOrganisationalUnitIdProvider_givenOne_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    OrganisationalUnitIdProvider instance = mock(OrganisationalUnitIdProvider.class);
    when(instance.organisationalUnitId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).organisationalUnitId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(OrganisationalUnitIdProvider)} with {@code OrganisationalUnitIdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(OrganisationalUnitIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(OrganisationalUnitIdProvider) with 'OrganisationalUnitIdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(OrganisationalUnitIdProvider)"})
  void testBuilderFromWithOrganisationalUnitIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    OrganisationalUnitIdProvider instance = mock(OrganisationalUnitIdProvider.class);
    when(instance.organisationalUnitId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).organisationalUnitId();
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentId()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    when(instance.parentId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).parentId();
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   * <ul>
   *   <li>Given {@code Provenance}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'; given 'Provenance'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider_givenProvenance_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#lastUpdate(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#lastUpdate(Optional)}
   */
  @Test
  @DisplayName("Test Builder lastUpdate(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lastUpdate(Optional)"})
  void testBuilderLastUpdateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    Optional<? extends Date> lastUpdate = Optional
        .of(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdate(lastUpdate));
  }

  /**
   * Test Builder {@link Builder#lifecyclePhase(LifecyclePhase)}.
   * <p>
   * Method under test: {@link Builder#lifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test Builder lifecyclePhase(LifecyclePhase)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lifecyclePhase(LifecyclePhase)"})
  void testBuilderLifecyclePhase() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lifecyclePhase(LifecyclePhase.PRODUCTION));
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#organisationalUnitId(Long)}.
   * <p>
   * Method under test: {@link Builder#organisationalUnitId(Long)}
   */
  @Test
  @DisplayName("Test Builder organisationalUnitId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.organisationalUnitId(Long)"})
  void testBuilderOrganisationalUnitId() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.organisationalUnitId(1L));
  }

  /**
   * Test Builder {@link Builder#parentId(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#parentId(long)}
   */
  @Test
  @DisplayName("Test Builder parentId(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentId(long)"})
  void testBuilderParentIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentId(1L));
  }

  /**
   * Test Builder {@link Builder#parentId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#parentId(Optional)}
   */
  @Test
  @DisplayName("Test Builder parentId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentId(Optional)"})
  void testBuilderParentIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();
    Optional<Long> parentId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.parentId(parentId));
  }

  /**
   * Test Builder {@link Builder#startDate(Date)}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#startDate(Date)}
   */
  @Test
  @DisplayName("Test Builder startDate(Date); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.startDate(Date)"})
  void testBuilderStartDate_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableChangeInitiative.builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.startDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Test Json {@link Json#changeInitiativeKind()}.
   * <p>
   * Method under test: {@link Json#changeInitiativeKind()}
   */
  @Test
  @DisplayName("Test Json changeInitiativeKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ChangeInitiativeKind Json.changeInitiativeKind()"})
  void testJsonChangeInitiativeKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).changeInitiativeKind());
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
  }

  /**
   * Test Json {@link Json#endDate()}.
   * <p>
   * Method under test: {@link Json#endDate()}
   */
  @Test
  @DisplayName("Test Json endDate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Date Json.endDate()"})
  void testJsonEndDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).endDate());
  }

  /**
   * Test Json {@link Json#externalId()}.
   * <p>
   * Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).externalId());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json {@link Json#kind()}.
   * <p>
   * Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).kind());
  }

  /**
   * Test Json {@link Json#lastUpdate()}.
   * <p>
   * Method under test: {@link Json#lastUpdate()}
   */
  @Test
  @DisplayName("Test Json lastUpdate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.lastUpdate()"})
  void testJsonLastUpdate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdate());
  }

  /**
   * Test Json {@link Json#lifecyclePhase()}.
   * <p>
   * Method under test: {@link Json#lifecyclePhase()}
   */
  @Test
  @DisplayName("Test Json lifecyclePhase()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LifecyclePhase Json.lifecyclePhase()"})
  void testJsonLifecyclePhase() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lifecyclePhase());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.organisationalUnitId);
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.endDate);
    assertNull(actualJson.startDate);
    assertNull(actualJson.kind);
    assertNull(actualJson.lifecyclePhase);
    assertNull(actualJson.changeInitiativeKind);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.lastUpdate.isPresent());
    assertFalse(actualJson.parentId.isPresent());
  }

  /**
   * Test Json {@link Json#organisationalUnitId()}.
   * <p>
   * Method under test: {@link Json#organisationalUnitId()}
   */
  @Test
  @DisplayName("Test Json organisationalUnitId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.organisationalUnitId()"})
  void testJsonOrganisationalUnitId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).organisationalUnitId());
  }

  /**
   * Test Json {@link Json#parentId()}.
   * <p>
   * Method under test: {@link Json#parentId()}
   */
  @Test
  @DisplayName("Test Json parentId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.parentId()"})
  void testJsonParentId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).parentId());
  }

  /**
   * Test Json {@link Json#provenance()}.
   * <p>
   * Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).provenance());
  }

  /**
   * Test Json {@link Json#startDate()}.
   * <p>
   * Method under test: {@link Json#startDate()}
   */
  @Test
  @DisplayName("Test Json startDate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Date Json.startDate()"})
  void testJsonStartDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).startDate());
  }
}
