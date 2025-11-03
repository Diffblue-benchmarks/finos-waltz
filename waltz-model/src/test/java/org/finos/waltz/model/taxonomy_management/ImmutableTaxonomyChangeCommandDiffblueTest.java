package org.finos.waltz.model.taxonomy_management;

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
import java.time.LocalDateTime;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import org.finos.waltz.model.CreatedProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.taxonomy_management.ImmutableTaxonomyChangeCommand.Builder;
import org.finos.waltz.model.taxonomy_management.ImmutableTaxonomyChangeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableTaxonomyChangeCommandDiffblueTest {
  /**
   * Test {@link ImmutableTaxonomyChangeCommand#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableTaxonomyChangeCommand#builder()}
   *   <li>{@link ImmutableTaxonomyChangeCommand#createdAt(LocalDateTime)}
   *   <li>{@link ImmutableTaxonomyChangeCommand#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableTaxonomyChangeCommand#status(TaxonomyChangeLifecycleStatus)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableTaxonomyChangeCommand Builder.build()", "Builder Builder.createdAt(LocalDateTime)",
      "Builder Builder.lastUpdatedAt(LocalDateTime)", "Builder Builder.status(TaxonomyChangeLifecycleStatus)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableTaxonomyChangeCommand.builder();
    Builder actualIdResult = actualBuilderResult.createdAt(LocalDate.of(1970, 1, 1).atStartOfDay()).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualIdResult2 = actualIdResult.id(id);
    Builder actualLastUpdatedAtResult = actualIdResult2.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    Builder actualParamsResult = actualLastUpdatedAtResult.params(new HashMap<>());

    // Assert
    assertSame(actualParamsResult, actualParamsResult.status(TaxonomyChangeLifecycleStatus.DRAFT));
  }

  /**
   * Test Builder {@link Builder#changeDomain(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#changeDomain(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder changeDomain(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.changeDomain(EntityReference)"})
  void testBuilderChangeDomain_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changeDomain(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#changeType(TaxonomyChangeType)}.
   * <p>
   * Method under test: {@link Builder#changeType(TaxonomyChangeType)}
   */
  @Test
  @DisplayName("Test Builder changeType(TaxonomyChangeType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.changeType(TaxonomyChangeType)"})
  void testBuilderChangeType() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changeType(TaxonomyChangeType.ADD_PEER));
  }

  /**
   * Test Builder {@link Builder#createdBy(String)}.
   * <p>
   * Method under test: {@link Builder#createdBy(String)}
   */
  @Test
  @DisplayName("Test Builder createdBy(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.createdBy(String)"})
  void testBuilderCreatedBy() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.createdBy("Jan 1, 2020 8:00am GMT+0100"));
  }

  /**
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   * <ul>
   *   <li>Given {@code Jan 1, 2020 8:00am GMT+0100}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CreatedProvider) with 'CreatedProvider'; given 'Jan 1, 2020 8:00am GMT+0100'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider_givenJan12020800amGmt0100_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CreatedProvider) with 'CreatedProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenThrow(new IllegalStateException("instance"));
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
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
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
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
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
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
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(TaxonomyChangeCommand)} with {@code TaxonomyChangeCommand}.
   * <p>
   * Method under test: {@link Builder#from(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(TaxonomyChangeCommand) with 'TaxonomyChangeCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(TaxonomyChangeCommand)"})
  void testBuilderFromWithTaxonomyChangeCommand() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    TaxonomyChangeCommand instance = mock(TaxonomyChangeCommand.class);
    when(instance.changeDomain()).thenThrow(new IllegalStateException("instance"));
    when(instance.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).changeDomain();
    verify(instance).changeType();
  }

  /**
   * Test Builder {@link Builder#from(TaxonomyChangeCommand)} with {@code TaxonomyChangeCommand}.
   * <p>
   * Method under test: {@link Builder#from(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(TaxonomyChangeCommand) with 'TaxonomyChangeCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(TaxonomyChangeCommand)"})
  void testBuilderFromWithTaxonomyChangeCommand2() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    TaxonomyChangeCommand instance = mock(TaxonomyChangeCommand.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.changeDomain()).thenReturn(mock(EntityReference.class));
    when(instance.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).changeDomain();
    verify(instance).changeType();
  }

  /**
   * Test Builder {@link Builder#from(TaxonomyChangeCommand)} with {@code TaxonomyChangeCommand}.
   * <p>
   * Method under test: {@link Builder#from(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(TaxonomyChangeCommand) with 'TaxonomyChangeCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(TaxonomyChangeCommand)"})
  void testBuilderFromWithTaxonomyChangeCommand3() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    TaxonomyChangeCommand instance = mock(TaxonomyChangeCommand.class);
    when(instance.params()).thenThrow(new IllegalStateException("instance"));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.primaryReference()).thenReturn(mock(EntityReference.class));
    when(instance.changeDomain()).thenReturn(mock(EntityReference.class));
    when(instance.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).changeDomain();
    verify(instance).changeType();
    verify(instance).params();
    verify(instance).primaryReference();
  }

  /**
   * Test Builder {@link Builder#from(TaxonomyChangeCommand)} with {@code TaxonomyChangeCommand}.
   * <ul>
   *   <li>Then builder build lastUpdatedBy is {@code 2020-03-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(TaxonomyChangeCommand) with 'TaxonomyChangeCommand'; then builder build lastUpdatedBy is '2020-03-01'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(TaxonomyChangeCommand)"})
  void testBuilderFromWithTaxonomyChangeCommand_thenBuilderBuildLastUpdatedByIs20200301() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    TaxonomyChangeCommand instance = mock(TaxonomyChangeCommand.class);
    when(instance.params()).thenReturn(new HashMap<>());
    when(instance.status()).thenReturn(TaxonomyChangeLifecycleStatus.DRAFT);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.primaryReference()).thenReturn(mock(EntityReference.class));
    when(instance.changeDomain()).thenReturn(mock(EntityReference.class));
    when(instance.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).changeDomain();
    verify(instance).changeType();
    verify(instance).params();
    verify(instance).primaryReference();
    verify(instance).status();
    ImmutableTaxonomyChangeCommand buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", buildResult.createdBy());
    assertEquals(TaxonomyChangeLifecycleStatus.DRAFT, buildResult.status());
    assertEquals(TaxonomyChangeType.ADD_PEER, buildResult.changeType());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(TaxonomyChangeCommand)} with {@code TaxonomyChangeCommand}.
   * <ul>
   *   <li>Then return build params {@code instance} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(TaxonomyChangeCommand) with 'TaxonomyChangeCommand'; then return build params 'instance' is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(TaxonomyChangeCommand)"})
  void testBuilderFromWithTaxonomyChangeCommand_thenReturnBuildParamsInstanceIs42() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    builderResult.putParams("instance", "42");
    TaxonomyChangeCommand instance = mock(TaxonomyChangeCommand.class);
    when(instance.params()).thenReturn(new HashMap<>());
    when(instance.status()).thenReturn(TaxonomyChangeLifecycleStatus.DRAFT);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.primaryReference()).thenReturn(mock(EntityReference.class));
    when(instance.changeDomain()).thenReturn(mock(EntityReference.class));
    when(instance.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).changeDomain();
    verify(instance).changeType();
    verify(instance).params();
    verify(instance).primaryReference();
    verify(instance).status();
    Map<String, String> paramsResult = actualFromResult.build().params();
    assertEquals(1, paramsResult.size());
    assertEquals("42", paramsResult.get("instance"));
    Map<String, String> paramsResult2 = builderResult.build().params();
    assertEquals(1, paramsResult2.size());
    assertEquals("42", paramsResult2.get("instance"));
  }

  /**
   * Test Builder {@link Builder#from(TaxonomyChangeCommand)} with {@code TaxonomyChangeCommand}.
   * <ul>
   *   <li>Then return build params {@code instance} is {@code instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(TaxonomyChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(TaxonomyChangeCommand) with 'TaxonomyChangeCommand'; then return build params 'instance' is 'instance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(TaxonomyChangeCommand)"})
  void testBuilderFromWithTaxonomyChangeCommand_thenReturnBuildParamsInstanceIsInstance() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("instance", "instance");
    TaxonomyChangeCommand instance = mock(TaxonomyChangeCommand.class);
    when(instance.params()).thenReturn(stringStringMap);
    when(instance.status()).thenReturn(TaxonomyChangeLifecycleStatus.DRAFT);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.primaryReference()).thenReturn(mock(EntityReference.class));
    when(instance.changeDomain()).thenReturn(mock(EntityReference.class));
    when(instance.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).changeDomain();
    verify(instance).changeType();
    verify(instance).params();
    verify(instance).primaryReference();
    verify(instance).status();
    Map<String, String> paramsResult = actualFromResult.build().params();
    assertEquals(1, paramsResult.size());
    assertEquals("instance", paramsResult.get("instance"));
    Map<String, String> paramsResult2 = builderResult.build().params();
    assertEquals(1, paramsResult2.size());
    assertEquals("instance", paramsResult2.get("instance"));
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
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

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
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#lastUpdatedBy(String)}.
   * <p>
   * Method under test: {@link Builder#lastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test Builder lastUpdatedBy(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lastUpdatedBy(String)"})
  void testBuilderLastUpdatedBy() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Test Builder {@link Builder#params(Map)}.
   * <ul>
   *   <li>Given builder params {@code null}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#params(Map)}
   */
  @Test
  @DisplayName("Test Builder params(Map); given builder params 'null'; when 'null'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.params(Map)"})
  void testBuilderParams_givenBuilderParamsNull_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    builderResult.params(null);

    // Act and Assert
    assertSame(builderResult, builderResult.params(null));
  }

  /**
   * Test Builder {@link Builder#params(Map)}.
   * <ul>
   *   <li>Given builder.</li>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#params(Map)}
   */
  @Test
  @DisplayName("Test Builder params(Map); given builder; when HashMap(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.params(Map)"})
  void testBuilderParams_givenBuilder_whenHashMap_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.params(new HashMap<>()));
  }

  /**
   * Test Builder {@link Builder#params(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code foo}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#params(Map)}
   */
  @Test
  @DisplayName("Test Builder params(Map); given 'foo'; when HashMap() 'foo' is 'foo'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.params(Map)"})
  void testBuilderParams_givenFoo_whenHashMapFooIsFoo_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    HashMap<String, String> entries = new HashMap<>();
    entries.put("foo", "foo");

    // Act and Assert
    assertSame(builderResult, builderResult.params(entries));
  }

  /**
   * Test Builder {@link Builder#primaryReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#primaryReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder primaryReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.primaryReference(EntityReference)"})
  void testBuilderPrimaryReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.primaryReference(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#putAllParams(Map)}.
   * <ul>
   *   <li>Given builder params {@link HashMap#HashMap()}.</li>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#putAllParams(Map)}
   */
  @Test
  @DisplayName("Test Builder putAllParams(Map); given builder params HashMap(); when HashMap(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.putAllParams(Map)"})
  void testBuilderPutAllParams_givenBuilderParamsHashMap_whenHashMap_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    builderResult.params(new HashMap<>());

    // Act and Assert
    assertSame(builderResult, builderResult.putAllParams(new HashMap<>()));
  }

  /**
   * Test Builder {@link Builder#putAllParams(Map)}.
   * <ul>
   *   <li>Given builder.</li>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#putAllParams(Map)}
   */
  @Test
  @DisplayName("Test Builder putAllParams(Map); given builder; when HashMap(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.putAllParams(Map)"})
  void testBuilderPutAllParams_givenBuilder_whenHashMap_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.putAllParams(new HashMap<>()));
  }

  /**
   * Test Builder {@link Builder#putAllParams(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code foo}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#putAllParams(Map)}
   */
  @Test
  @DisplayName("Test Builder putAllParams(Map); given 'foo'; when HashMap() 'foo' is 'foo'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.putAllParams(Map)"})
  void testBuilderPutAllParams_givenFoo_whenHashMapFooIsFoo_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    HashMap<String, String> entries = new HashMap<>();
    entries.put("foo", "foo");

    // Act and Assert
    assertSame(builderResult, builderResult.putAllParams(entries));
  }

  /**
   * Test Builder {@link Builder#putParams(Entry)} with {@code entry}.
   * <ul>
   *   <li>Given builder Params {@code params key} is {@code 42}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#putParams(Entry)}
   */
  @Test
  @DisplayName("Test Builder putParams(Entry) with 'entry'; given builder Params 'params key' is '42'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.putParams(Entry)"})
  void testBuilderPutParamsWithEntry_givenBuilderParamsParamsKeyIs42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();
    builderResult.putParams("params key", "42");

    // Act and Assert
    assertSame(builderResult, builderResult.putParams(new SimpleEntry<>("foo", "foo")));
  }

  /**
   * Test Builder {@link Builder#putParams(Entry)} with {@code entry}.
   * <ul>
   *   <li>When {@link AbstractMap.SimpleEntry#SimpleEntry(Object, Object)} with {@code foo} and {@code foo}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#putParams(Entry)}
   */
  @Test
  @DisplayName("Test Builder putParams(Entry) with 'entry'; when SimpleEntry(Object, Object) with 'foo' and 'foo'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.putParams(Entry)"})
  void testBuilderPutParamsWithEntry_whenSimpleEntryWithFooAndFoo_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.putParams(new SimpleEntry<>("foo", "foo")));
  }

  /**
   * Test Builder {@link Builder#putParams(String, String)} with {@code key}, {@code value}.
   * <ul>
   *   <li>Given builder.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#putParams(String, String)}
   */
  @Test
  @DisplayName("Test Builder putParams(String, String) with 'key', 'value'; given builder; when '42'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.putParams(String, String)"})
  void testBuilderPutParamsWithKeyValue_givenBuilder_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.putParams("Key", "42"));
  }

  /**
   * Test Json {@link Json#changeDomain()}.
   * <p>
   * Method under test: {@link Json#changeDomain()}
   */
  @Test
  @DisplayName("Test Json changeDomain()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.changeDomain()"})
  void testJsonChangeDomain() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).changeDomain());
  }

  /**
   * Test Json {@link Json#changeType()}.
   * <p>
   * Method under test: {@link Json#changeType()}
   */
  @Test
  @DisplayName("Test Json changeType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TaxonomyChangeType Json.changeType()"})
  void testJsonChangeType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).changeType());
  }

  /**
   * Test Json {@link Json#createdAt()}.
   * <p>
   * Method under test: {@link Json#createdAt()}
   */
  @Test
  @DisplayName("Test Json createdAt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.createdAt()"})
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).createdAt());
  }

  /**
   * Test Json {@link Json#createdBy()}.
   * <p>
   * Method under test: {@link Json#createdBy()}
   */
  @Test
  @DisplayName("Test Json createdBy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.createdBy()"})
  void testJsonCreatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).createdBy());
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
   * Test Json {@link Json#lastUpdatedAt()}.
   * <p>
   * Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdatedAt());
  }

  /**
   * Test Json {@link Json#lastUpdatedBy()}.
   * <p>
   * Method under test: {@link Json#lastUpdatedBy()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedBy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.lastUpdatedBy()"})
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdatedBy());
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
    assertNull(actualJson.createdBy);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.createdAt);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.params);
    assertNull(actualJson.changeDomain);
    assertNull(actualJson.primaryReference);
    assertNull(actualJson.status);
    assertNull(actualJson.changeType);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test Json {@link Json#params()}.
   * <p>
   * Method under test: {@link Json#params()}
   */
  @Test
  @DisplayName("Test Json params()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map Json.params()"})
  void testJsonParams() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).params());
  }

  /**
   * Test Json {@link Json#primaryReference()}.
   * <p>
   * Method under test: {@link Json#primaryReference()}
   */
  @Test
  @DisplayName("Test Json primaryReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.primaryReference()"})
  void testJsonPrimaryReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).primaryReference());
  }

  /**
   * Test Json {@link Json#status()}.
   * <p>
   * Method under test: {@link Json#status()}
   */
  @Test
  @DisplayName("Test Json status()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TaxonomyChangeLifecycleStatus Json.status()"})
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).status());
  }
}
