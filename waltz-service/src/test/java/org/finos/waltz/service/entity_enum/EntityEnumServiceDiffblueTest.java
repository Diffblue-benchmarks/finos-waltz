package org.finos.waltz.service.entity_enum;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.entity_enum.EntityEnumDefinitionDao;
import org.finos.waltz.data.entity_enum.EntityEnumValueDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.entity_enum.EntityEnumDefinition;
import org.finos.waltz.model.entity_enum.EntityEnumValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EntityEnumServiceDiffblueTest {
  @Mock private EntityEnumDefinitionDao entityEnumDefinitionDao;

  @InjectMocks private EntityEnumService entityEnumService;

  @Mock private EntityEnumValueDao entityEnumValueDao;

  /**
   * Test {@link EntityEnumService#findDefinitionsByEntityKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityEnumService#findDefinitionsByEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test findDefinitionsByEntityKind(EntityKind); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityEnumService.findDefinitionsByEntityKind(EntityKind)"})
  void testFindDefinitionsByEntityKind_thenReturnEmpty() {
    // Arrange
    when(entityEnumDefinitionDao.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityEnumDefinition> actualFindDefinitionsByEntityKindResult =
        entityEnumService.findDefinitionsByEntityKind(EntityKind.ALL);

    // Assert
    verify(entityEnumDefinitionDao).findByEntityKind(EntityKind.ALL);
    assertTrue(actualFindDefinitionsByEntityKindResult.isEmpty());
  }

  /**
   * Test {@link EntityEnumService#findValuesByEntity(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityEnumService#findValuesByEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findValuesByEntity(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityEnumService.findValuesByEntity(EntityReference)"})
  void testFindValuesByEntity_thenReturnEmpty() {
    // Arrange
    when(entityEnumValueDao.findByEntity(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityEnumValue> actualFindValuesByEntityResult =
        entityEnumService.findValuesByEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(entityEnumValueDao).findByEntity(isA(EntityReference.class));
    assertTrue(actualFindValuesByEntityResult.isEmpty());
  }
}
